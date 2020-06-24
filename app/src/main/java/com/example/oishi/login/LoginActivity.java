package com.example.oishi.login;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oishi.MainActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    String txtId;
    MaterialEditText id_Text, password_Text;
    CheckBox login_Checkbox;
    Button login_Button;
    TextView register_Button, search_id_Button, search_password_Button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final Intent[] intent = new Intent[3];
        intent[0] = new Intent(LoginActivity.this, MainActivity.class);
        intent[1] = new Intent(LoginActivity.this, RegisterActivity.class);
        intent[2] = new Intent(LoginActivity.this, FindActivity.class);

        id_Text = findViewById(R.id.id_Text);
        password_Text = findViewById(R.id.password_Text);
        login_Checkbox = findViewById(R.id.login_Checkbox);
        login_Button = findViewById(R.id.login_Button);
        register_Button = findViewById(R.id.register_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginState), "");
        if (loginStatus.equals("log-in")) {
            startActivity(intent[0]);
            LoginActivity.this.finish();
        }


        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent[1]);
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword)) {
                    Toast.makeText(LoginActivity.this, "빈칸을 채워 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://ykh3587.dothome.co.kr/login.php";

                    ContentValues values = new ContentValues();
                    values.put("userid", txtId);
                    values.put("password", txtPassword);
                    Context context = getApplicationContext();
                    String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    values.put("local", local);
                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();
                }
            }
        });

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[2].putExtra("type", getString(R.string.find_id));
                startActivity(intent[2]);
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[2].putExtra("type", getString(R.string.find_password));
                startActivity(intent[2]);
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

            asyncDialog = ProgressDialog.show(LoginActivity.this, "Please Wait", null, true, true);
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

            if (results.equals("Login Success")) {
                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (login_Checkbox.isChecked()) {
                    editor.putString(getResources().getString(R.string.prefLoginState), "log-in");
                }
                else {
                    editor.putString(getResources().getString(R.string.prefLoginState), "log-out");
                }
                editor.apply();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();
            }

            else {
                Toast.makeText(LoginActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }
}