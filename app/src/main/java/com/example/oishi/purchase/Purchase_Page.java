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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oishi.MainActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.map.Real_Write_Address;

import org.json.JSONArray;
import org.json.JSONObject;

public class Purchase_Page extends AppCompatActivity {

    String phone_number, local;

    RelativeLayout PURCHASE_BILL, PURCHASE_BILL2, PURCHASE_BILL3;
    Button PURCHASE;
    Button ALTER_NUMBER;
    Button ALTER_PURCHASE;
    EditText DETAIL_ADDRESS;
    TextView PHONE_NUMBER, ADDRESS, VIEW_PURCHASE;
    TextView PURCHASE_SOLUTION, TOTALPRICE, TOTALPRICE_AND_ALPHA;
    private static final String TAG_PHONENUMBER = "mobile";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_TOTALSUM = "totalsum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase__page);

        DETAIL_ADDRESS = findViewById(R.id.detail_address);
        TOTALPRICE = findViewById(R.id.total_price);
        TOTALPRICE_AND_ALPHA = findViewById(R.id.total_price_and_alpha);
        PURCHASE_BILL = findViewById(R.id.purchase_bill);
        PURCHASE_BILL2 = findViewById(R.id.purchase_bill2);
        PURCHASE_BILL3 = findViewById(R.id.purchase_bill3);
        PURCHASE = findViewById(R.id.next_purchase);
        ALTER_NUMBER = findViewById(R.id.number_alter);
        ALTER_PURCHASE = findViewById(R.id.purchase_alter);
        PHONE_NUMBER = findViewById(R.id.phone_number);
        PURCHASE_SOLUTION = findViewById(R.id.purchase_solution);
        ADDRESS = findViewById(R.id.address);
        VIEW_PURCHASE = findViewById(R.id.view_purchase);

        phone_number = PHONE_NUMBER.getText().toString();

        PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittext = DETAIL_ADDRESS.getText().toString();
                String to = TOTALPRICE.getText().toString();
                if(edittext.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(),"상세주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(ADDRESS.getText().toString() == "null"){
                    Toast.makeText(getApplicationContext(),"주소 정보가 없습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Real_Write_Address.class);
                    startActivity(intent);
                    finish();
                }
                else if(to.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(),"결제금액을 눌러 확인해주세요!\n 또는 선택하신 물품이 없습니다.\n장바구니에 물품을 넣어주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "결제 완료", Toast.LENGTH_SHORT).show();
                    String url = "http://ykh3587.dothome.co.kr/remove_user_info.php";
                    Context context = getApplicationContext();
                    local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    ContentValues values = new ContentValues();
                    values.put("local", local);
                    BackgroundTask2 task = new BackgroundTask2(url, values);
                    task.execute();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        ALTER_NUMBER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Phone_number_alter.class);
                intent.putExtra("present_number", phone_number);
                startActivityForResult(intent, 1);
            }
        });

        ALTER_PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_alter.class);
                startActivityForResult(intent, 2);
            }
        });

        VIEW_PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PURCHASE_BILL.setVisibility(View.VISIBLE);
                    PURCHASE_BILL2.setVisibility(View.VISIBLE);
                    PURCHASE_BILL3.setVisibility(View.VISIBLE);
                    VIEW_PURCHASE.setText("결제금액");
                String url = "http://ykh3587.dothome.co.kr/loadtotalsum.php";
                Context context = getApplicationContext();
                local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                ContentValues values = new ContentValues();
                values.put("local", local);
                BackgroundTask2 task = new BackgroundTask2(url, values);
                task.execute();
            }
        });

        String url = "http://ykh3587.dothome.co.kr/loaduser.php";
        Context context = getApplicationContext();
        local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        ContentValues values = new ContentValues();
        values.put("local", local);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("alter_phone_number");
                PHONE_NUMBER.setText(result);
            }
        }

        else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("purchase");
                PURCHASE_SOLUTION.setText(result);
            }
        }
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

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                String location = ((JSONObject) jsonArray.get(0)).getString(TAG_LOCATION);
                String phonenumber = ((JSONObject) jsonArray.get(0)).getString(TAG_PHONENUMBER);

                ADDRESS.setText(location);
                PHONE_NUMBER.setText(phonenumber);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class BackgroundTask2 extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask2(String url, ContentValues values) {
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

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                String totalsum = ((JSONObject) jsonArray.get(0)).getString(TAG_TOTALSUM);

                TOTALPRICE.setText(totalsum+"원");

                TOTALPRICE_AND_ALPHA.setText((Integer.parseInt(totalsum) + 2000) + "원");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
