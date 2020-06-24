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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oishi.FoodDetailActivity;
import com.example.oishi.MainActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.detail_menu.DetailMenuFragment;
import com.example.oishi.detail_menu.detailmenuItem;
import com.example.oishi.detail_menu.detailmenuItemAdapter;
import com.example.oishi.detail_menu.detailmenuLayoutManager;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Shopping_basket extends AppCompatActivity {
    PurchaseRecyclerView recyclerView;
    public PurchaseItemAdapter adapter;
    PurchaseLayoutManager layout;
    String local;
    public int totalsum = 0;
    TextView total_sum, more;
    RadioButton delevery, packing;
    Button nextpage;
    public String foodname, foodprice, count;
    private static final String TAG_FOODNAME = "foodname";
    private static final String TAG_FOODPRICE = "foodprice";
    private static final String TAG_COUNT = "count";
    ArrayList<HashMap<String, String>> review_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);
        more = findViewById(R.id.more);
        delevery = findViewById(R.id.deliverybutton);
        nextpage = findViewById(R.id.next_purchase);
        packing = findViewById(R.id.packingbutton);
        total_sum = findViewById(R.id.total_price);
        adapter = new PurchaseItemAdapter(getApplicationContext());
        recyclerView = findViewById(R.id.order_list);
        review_List = new ArrayList<HashMap<String,String>>();
        String url = "http://ykh3587.dothome.co.kr/read_shopping_basket.php";
        Context context = getApplicationContext();
        local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        ContentValues values = new ContentValues();
        values.put("local", local);
        System.out.println(local);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        delevery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packing.setChecked(false);
            }
        });

        packing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delevery.setChecked(false);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delevery.isChecked() == false && packing.isChecked() == false)
                {
                    Toast.makeText(Shopping_basket.this, "배달 혹은 포장을 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                    startActivity(intent);
                }
            }
        });
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
                    foodname = c.getString(TAG_FOODNAME);
                    foodprice = c.getString(TAG_FOODPRICE);
                    count = c.getString(TAG_COUNT);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_FOODNAME, foodname);
                    persons.put(TAG_FOODPRICE, foodprice);
                    persons.put(TAG_COUNT, count);

                    review_List.add(persons);
                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new PurchaseItem(hashMap.get(TAG_FOODNAME), hashMap.get(TAG_FOODPRICE), hashMap.get(TAG_COUNT)));
                    System.out.println(hashMap.get(TAG_FOODNAME));
                    System.out.println(hashMap.get(TAG_FOODPRICE));
                    System.out.println(hashMap.get(TAG_COUNT));


                }
                recyclerView.setHasFixedSize(true);

                layout = new PurchaseLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTotalPriceText(int Total_Price) {
        //가게 최소주문금액
        int index = 0;
        int[] total_price_array = null;
        total_price_array[index] = Total_Price / 1000;

        while(true) {
            if (total_price_array[index] < 1000) {
                total_price_array[index] = Total_Price % 1000;
                total_price_array[index+1] = Total_Price / 1000;
                break;
            }
            else {
                total_price_array[index] = Total_Price % 1000;
                Total_Price = Total_Price / 1000;
                total_price_array[index+1] = Total_Price / 1000;
            }
            index++;
        }
        StringBuilder total_price_text = null;

        for(int i=total_price_array.length ; i > 0 ; i--) {
            if(i==1) {
                if(total_price_array[i - 1] < 100) {
                    if(total_price_array[i - 1] < 10) {
                        total_price_text.append("0").append(total_price_array[i - 1]).append("원");
                    }
                    else {
                        total_price_text.append("00").append(total_price_array[i - 1]).append("원");
                    }
                }
                else {
                    total_price_text.append(total_price_array[i - 1]).append("원");
                }
            }
            else {
                if(total_price_array[i - 1] < 100) {
                    if(total_price_array[i - 1] < 10) {
                        total_price_text.append("0").append(total_price_array[i - 1]).append(",");
                    }
                    else {
                        total_price_text.append("00").append(total_price_array[i - 1]).append(",");
                    }
                }
                else {
                    total_price_text.append(total_price_array[i - 1]).append(",");
                }
            }
        }
        //주문 리스트의 총합 지정하기
        //total_price.setText(total_price_text);
    }
}
