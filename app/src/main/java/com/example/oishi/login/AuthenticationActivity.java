package com.example.oishi.login;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class AuthenticationActivity extends AppCompatActivity {

    MaterialEditText authentic_Text;
    Button confirm_Button;
    LinearLayout found_Content;
    TextView found_Text, login_Button, search_id_Button, search_password_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        Intent authentication = getIntent();
        final int key = authentication.getExtras().getInt("key");
        final String email = authentication.getExtras().getString("email");

        authentic_Text = findViewById(R.id.authentic_Text);
        confirm_Button = findViewById(R.id.confirm_Button);
        found_Content = findViewById(R.id.found_Content);
        found_Text = findViewById(R.id.found_Text);
        login_Button = findViewById(R.id.login_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);

        final Intent[] intent = new Intent[2];
        intent[0] = new Intent(AuthenticationActivity.this, LoginActivity.class);
        intent[1] = new Intent(AuthenticationActivity.this, FindActivity.class);

        confirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtAuthentic = authentic_Text.getText().toString();
                if (key == Integer.parseInt(txtAuthentic)) {

                    String url = "http://ykh3587.dothome.co.kr/showme.php";

                    ContentValues values = new ContentValues();
                    values.put("email", email);

                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();

                    found_Content.setVisibility(View.VISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "인증번호가 맞습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    found_Content.setVisibility(View.INVISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "잘못된 인증번호입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent[0]);
                AuthenticationActivity.this.finish();
            }
        });

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[1].putExtra("key", getString(R.string.find_id));
                startActivity(intent[1]);
                AuthenticationActivity.this.finish();
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[1].putExtra("key", getString(R.string.find_password));
                startActivity(intent[1]);
                AuthenticationActivity.this.finish();
            }
        });
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

            asyncDialog = ProgressDialog.show(AuthenticationActivity.this, "Please Wait", null, true, true);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            Intent authentication = getIntent();
            String type = authentication.getExtras().getString("type");

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                String userid = null;
                String password = null;
                System.out.println(jsonArray);
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    userid = c.getString("userid");
                    password = c.getString("password");
                }
                if(Objects.equals(type, getString(R.string.find_id))) {
                    String txtFound = "ID : " + userid;
                    found_Text.setText(txtFound);
                }
                else if(Objects.equals(type, getString(R.string.find_password))) {
                    String txtFound = "PW : " + password;
                    found_Text.setText(txtFound);
                }
            } catch (Exception e) {
                Toast.makeText(AuthenticationActivity.this, results, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}