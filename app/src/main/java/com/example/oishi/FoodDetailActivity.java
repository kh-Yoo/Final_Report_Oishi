package com.example.oishi;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.oishi.detail_menu.DetailMenuFragment;
import com.example.oishi.food_brand.FoodBrandListViewItem;
import com.example.oishi.main_fragment.InfoFragment;
import com.example.oishi.main_fragment.ReviewFragment;
import com.example.oishi.main_fragment.UserFragment;
import com.example.oishi.purchase.Shopping_basket;
import com.example.oishi.review.Item;
import com.example.oishi.review.PopupActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.mail.Store;

public class FoodDetailActivity extends AppCompatActivity {
    FoodPagerAdapter adapter = new FoodPagerAdapter(getSupportFragmentManager());
    public FoodBrandListViewItem main_store_info;
    public int state;
    public String Store_Name, local, Food_Type, Brand_Name;
    SharedPreferences sharedPreferences;
    TextView food_detail_Text, main_store_name_Text, main_store_rating_Text;
    TextView main_store_review_Text, main_store_phone_number_Text;
    TextView main_store_min_price_Text, main_store_delivery_time_Text, main_store_delivery_tip_Text;
    CustomTextView main_store_favorite_Text;
    StickyScrollView main_scroll_view;
    TabLayout food_detail_TabLayout;
    MeasuredViewPager food_detail_Container;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        Intent intent = getIntent();
        Brand_Name = intent.getExtras().getString("brand_name");
        Food_Type = intent.getExtras().getString("foodtype");

        String url = "http://ykh3587.dothome.co.kr/food_detail.php";

        ContentValues values = new ContentValues();
        values.put("Brand_Name", Brand_Name);
        Context context = getApplicationContext();
        local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        values.put("local", local);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            asyncDialog = ProgressDialog.show(FoodDetailActivity.this, "Please Wait", null, true, true);
            main_store_info = new FoodBrandListViewItem();

            sharedPreferences = getSharedPreferences("Favorite-Store", Context.MODE_PRIVATE);

            food_detail_Text = findViewById(R.id.food_detail_Text);
            main_store_name_Text = findViewById(R.id.main_store_name_Text);
            main_store_rating_Text = findViewById(R.id.main_store_rating_Text);
            main_store_review_Text = findViewById(R.id.main_store_review_Text);
            main_store_phone_number_Text = findViewById(R.id.main_store_phone_number_Text);
            main_store_favorite_Text = findViewById(R.id.main_store_favorite_Text);
            main_store_min_price_Text = findViewById(R.id.main_store_min_price_Text);
            main_store_delivery_time_Text = findViewById(R.id.main_store_delivery_time_Text);
            main_store_delivery_tip_Text = findViewById(R.id.main_store_delivery_tip_Text);

            main_scroll_view = findViewById(R.id.main_scroll_view);
            food_detail_Container = findViewById(R.id.food_detail_Container);
            food_detail_TabLayout = findViewById(R.id.food_detail_TabLayout);
            fab = findViewById(R.id.fab);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("read");
                main_store_info = gson.fromJson(jsonArray.get(0).toString(), FoodBrandListViewItem.class);

                Store_Name = main_store_info.getMain_Store_Name();

                //AppBar 제목
                food_detail_Text.setText(main_store_info.getMain_Store_Name());
                //가게 이름
                main_store_name_Text.setText(main_store_info.getMain_Store_Name());
                //가게 별점
                main_store_rating_Text.setText(String.format("%s", main_store_info.getMain_Store_Rating()));
                //가게 리뷰 수
                main_store_review_Text.setText(String.format("최근 리뷰 %s", main_store_info.getMain_Store_Review()));
                //가게 전화번호
                main_store_phone_number_Text.setText("전화");
                main_store_phone_number_Text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + main_store_info.getMain_Store_Phone_Number()));
                        if(intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });
                //가게 찜
                setFavoriteText(sharedPreferences);
                main_store_favorite_Text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //레드 하트(2131165394)
                        int favorite_red = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_black_24dp", "drawable", getApplicationContext().getPackageName());
                        //빈 하트(2131165395)
                        int favorite_blank = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_border_black_24dp", "drawable", getApplicationContext().getPackageName());

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        //찜을 안한 경우
                        if (state == favorite_blank) {
                            editor.putString(getResources().getString(R.string.prefFavoriteState), main_store_info.getMain_Store_Name());
                            main_store_favorite_Text.setText(String.format("찜%d", main_store_info.getMain_Store_Favorite()+1));
                            main_store_favorite_Text.setCompoundDrawablesRelativeWithIntrinsicBounds(getDrawable(R.drawable.ic_favorite_black_24dp),  null, null, null);
                            state = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_black_24dp", "drawable", getApplicationContext().getPackageName());
                        }
                        //찜을 한 경우
                        else if (state == favorite_red){
                            editor.putString(getResources().getString(R.string.prefFavoriteState), null);
                            main_store_favorite_Text.setText(String.format("찜%d", main_store_info.getMain_Store_Favorite()));
                            main_store_favorite_Text.setCompoundDrawablesRelativeWithIntrinsicBounds(getDrawable(R.drawable.ic_favorite_border_black_24dp), null, null, null);
                            state = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_border_black_24dp", "drawable", getApplicationContext().getPackageName());
                        }
                        editor.apply();
                    }
                });
                //가게 최소 주문 금액
                setMinPriceText(main_store_info.getMain_Store_Min_Price());
                //가게 배달 시간
                main_store_delivery_time_Text.setText(String.format("%s 소요 예상", main_store_info.getMain_Store_Delivery_Time()));
                //가게 배달팁
                setDeliveryTipText(main_store_info.getMain_Store_Delivery_Tip());

                //main_scroll_view.setShadowDrawable(getResources().getDrawable(R.drawable.shadow_drawable));
                main_scroll_view.setShadowHeight(50); // in pixels

                InfoFragment infoFragment = new InfoFragment();
                Bundle bundle = new Bundle(8);
                bundle.putInt("order_number", main_store_info.getMain_Store_Order_Number());
                bundle.putInt("review", main_store_info.getMain_Store_Review());
                bundle.putInt("favorite", main_store_info.getMain_Store_Favorite());
                bundle.putInt("min_price", main_store_info.getMain_Store_Min_Price());
                bundle.putInt("delivery_tip", main_store_info.getMain_Store_Delivery_Tip());
                bundle.putString("running_time", main_store_info.getMain_Store_Running_Time());
                bundle.putString("holiday", main_store_info.getMain_Store_Holiday());
                bundle.putString("phone_number", main_store_info.getMain_Store_Phone_Number());
                infoFragment.setArguments(bundle);

                adapter.addFragment("메뉴", new DetailMenuFragment(Brand_Name, Food_Type));
                adapter.addFragment("정보", infoFragment);
                adapter.addFragment("리뷰", new ReviewFragment());

                food_detail_TabLayout.setupWithViewPager(food_detail_Container);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Shopping_basket.class);
                        startActivity(intent);
                    }
                });

                food_detail_Container.setAdapter(adapter);

                food_detail_TabLayout.setupWithViewPager(food_detail_Container);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setFavoriteText(SharedPreferences sharedPreferences) {
        String favoriteState = sharedPreferences.getString(getResources().getString(R.string.prefFavoriteState), "");
        //이전에 가게를 찜했을 경우
        if (favoriteState.equals(main_store_info.getMain_Store_Name())) {
            main_store_favorite_Text.setText(String.format("찜%d", main_store_info.getMain_Store_Favorite()+1));
            main_store_favorite_Text.setCompoundDrawablesRelativeWithIntrinsicBounds(getDrawable(R.drawable.ic_favorite_black_24dp),  null, null, null);
            state = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_black_24dp", "drawable", getApplicationContext().getPackageName());
        }
        //이전에 가게를 찜하지 않았을 경우
        else {
            main_store_favorite_Text.setText(String.format("찜%d", main_store_info.getMain_Store_Favorite()));
            main_store_favorite_Text.setCompoundDrawablesRelativeWithIntrinsicBounds(getDrawable(R.drawable.ic_favorite_border_black_24dp),  null, null, null);
            state = getApplicationContext().getResources().getIdentifier("@drawable/ic_favorite_border_black_24dp", "drawable", getApplicationContext().getPackageName());
        }
    }

    public void setMinPriceText(int Min_Price) {
        //가게 최소주문금액
        int min_price_Thousands = Min_Price/1000;
        int min_price_Hundred = Min_Price%1000;
        if(min_price_Hundred == 0) {
            main_store_min_price_Text.setText(String.format("%d,000원", min_price_Thousands));
        }
        else {
            main_store_min_price_Text.setText(String.format("%d,%d원", min_price_Thousands, min_price_Hundred));
        }
    }

    public void setDeliveryTipText(int Delivery_Tip) {
        //배달팁이 0원일때
        if(Delivery_Tip == 0) {
            main_store_delivery_tip_Text.setText("무료");
        }
        //배달팁이 0원이 아닐때
        else {
            int delivery_tip_Thousands = Delivery_Tip/1000;
            int delivery_tip_Hundred = Delivery_Tip%1000;
            //배달팁의 백원 단위가 0일때
            if(delivery_tip_Hundred == 0) {
                main_store_delivery_tip_Text.setText(String.format("%d,000원", delivery_tip_Thousands));
            }
            //배달팁의 백원 단위가 0이 아닐떄
            else {
                main_store_delivery_tip_Text.setText(String.format("%d,%d원", delivery_tip_Thousands, delivery_tip_Hundred));
            }
        }
    }


}
