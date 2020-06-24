package com.example.oishi.map;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.oishi.FoodDetailActivity;
import com.example.oishi.MainActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.detail_menu.detailmenuItem;
import com.example.oishi.detail_menu.detailmenuLayoutManager;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Real_Write_Address extends AppCompatActivity {
    String ADDRESS;
    Button map_search_button, search_button, next_page_button;
    EditText frame_address, detail_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_address);

        map_search_button = findViewById(R.id.map_search_button);
        search_button = findViewById(R.id.search_button);
        next_page_button = findViewById(R.id.next_page_button);
        frame_address = findViewById(R.id.frame_address);
        detail_address = findViewById(R.id.detail_address);

        //"주소 검색" 버튼 클릭시 activity_search2 로 화면 전환
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivityForResult(intent,2);
            }
        });
        //"현재 위치" 버튼 클릭시 activity_map_search 로 화면 전환
        map_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Map_Search.class);
                startActivityForResult(intent, 3);
            }
        });
        //"확인" 버튼 클릭시 사용자가 지정한 주소의 문자열을
        // 데이터베이스 내 users_table테이블에 저장 후 MainActivity.HomeFragment 로 화면 전환
        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://ykh3587.dothome.co.kr/putlocation.php";

                ContentValues values = new ContentValues();
                Context context = getApplicationContext();
                String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                values.put("local", local);
                String Address = frame_address.getText().toString();
                values.put("location", Address);
                BackgroundTask task = new BackgroundTask(url, values);
                task.execute();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("location", ADDRESS);
                startActivity(intent);

            }
        });
    }

    //다른 액티비티에서 현재 액티비티로 이동을 하였을때 전달 받은 값이 어떤 형태 인지 확인 후 저장
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                ADDRESS = data.getStringExtra("location");
                frame_address.setText(ADDRESS);
            }
        }
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                ADDRESS = data.getStringExtra("location");
                frame_address.setText(ADDRESS);
            }
        }
    }

    //사용자의 주소 저장 과정에서 AsyncTask 동작
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
