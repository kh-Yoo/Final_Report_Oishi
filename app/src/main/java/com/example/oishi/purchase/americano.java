package com.example.oishi.purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oishi.FoodDetailActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.review.ReviewItem;
import com.example.oishi.review.ReviewItemAdapter;
import com.example.oishi.review.ReviewLayoutManager;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class americano extends AppCompatActivity {
    int count = 1;
    public String store_title, FoodName, StoreName, FoodPrice, FoodImg, local, Food_Type;

    public ArrayList<ReviewItem> visibleItems = new ArrayList<>();
    Context mContext = americano.this;
    PurchaseRecyclerView recyclerView;

    private static final String TAG_UID = "id";
    private static final String TAG_CONTENT ="content";
    private static final String TAG_RATING = "rating";
    private static final String TAG_TIME = "present";
    ArrayList<HashMap<String, String>> review_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        ImageButton COUNT_DOWN = findViewById(R.id.count_down);
        ImageButton COUNT_UP = findViewById(R.id.count_up);
        final TextView COUNT_NUMBER = findViewById(R.id.count_number);
        final TextView BASE_PRICE = findViewById(R.id.menu_base_price);
        final TextView TITLE = findViewById(R.id.title);
        final TextView Store_Title = findViewById(R.id.store_name_Text);
        final ImageView Food_Img = findViewById(R.id.menu_image);
        final Button Shopping_Basket = findViewById(R.id.put_shopping_basket);

        Intent intent = getIntent();
        FoodName = intent.getExtras().getString("foodname");
        StoreName = intent.getExtras().getString("storename");
        FoodPrice = intent.getExtras().getString("foodprice");
        FoodImg = intent.getExtras().getString("foodimg");
        Food_Type = intent.getExtras().getString("foodtype");
        TITLE.setText(FoodName);
        System.out.println(FoodName);
        Store_Title.setText(StoreName);
        BASE_PRICE.setText(FoodPrice);
        Food_Img.setImageResource(getResources().getIdentifier(FoodImg, "drawable", this.getPackageName()));
        local = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        COUNT_NUMBER.setText("" +count+"");
        Context context = this;

        COUNT_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                COUNT_NUMBER.setText(String.format("%s", count));
            }
        });

        COUNT_DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count < 1)
                {count = 1;}

                COUNT_NUMBER.setText(String.format("%s", count));
            }
        });

        Shopping_Basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url2 = "http://ykh3587.dothome.co.kr/shopping_basket.php";
                ContentValues values = new ContentValues();
                values.put("storename", StoreName);
                values.put("foodname", FoodName);
                values.put("foodprice", FoodPrice);
                values.put("count", count);
                values.put("local", local);
                BackgroundTask task2 = new BackgroundTask(url2, values);
                task2.execute();

                Intent intent = new Intent(getApplicationContext(), FoodDetailActivity.class);
                intent.putExtra("brand_name", StoreName);
                intent.putExtra("foodtype", Food_Type);
                startActivity(intent);

            }
        });

        review_List = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        String url = "http://ykh3587.dothome.co.kr/read_review.php";

        BackgroundTask task = new BackgroundTask(url, null);
        task.execute();

    }
    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

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

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String uid = c.getString(TAG_UID);
                    String content = c.getString(TAG_CONTENT);
                    String rating = c.getString(TAG_RATING);
                    String time = c.getString(TAG_TIME);

                    HashMap<String,String> persons = new HashMap<>();

                    persons.put(TAG_UID,uid);
                    persons.put(TAG_CONTENT,content);
                    persons.put(TAG_RATING, rating);
                    persons.put(TAG_TIME, time);

                    review_List.add(persons);
/*


                    adapter.addItem(new MenuSortItem(uid, name,content));

                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new MenuSortItemLayoutManager(mContext));*/
                }

                ReviewItemAdapter adapter = new ReviewItemAdapter(mContext);

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new ReviewItem(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME)));
                   //System.out.println(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME));
                }

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new ReviewLayoutManager(mContext));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                store_title = data.getStringExtra("store_title");
            }
        }
    }
}
