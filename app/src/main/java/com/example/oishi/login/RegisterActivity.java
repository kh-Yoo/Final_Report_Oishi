package com.example.oishi.login;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText id_Text, password_Text, name_Text, email_Text, phone_Text;
    RadioGroup sex_RadioGroup;
    Button register_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id_Text= findViewById(R.id.id_Text);
        password_Text= findViewById(R.id.password_Text);
        name_Text= findViewById(R.id.name_Text);
        email_Text= findViewById(R.id.email_Text);
        phone_Text= findViewById(R.id.phone_Text);

        sex_RadioGroup = findViewById(R.id.sex_RadioGroup);
        register_Button = findViewById(R.id.register_Button);

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                String txtName = name_Text.getText().toString();
                String txtEmail = email_Text.getText().toString();
                String txtPhone = phone_Text.getText().toString();

                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 중 하나라도 공백일 경우
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword) || TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPhone)) {
                    Toast.makeText(RegisterActivity.this, "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show();
                }
                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 모두 입력 되어 있을 경우
                else {
                    int genderId = sex_RadioGroup.getCheckedRadioButtonId();
                    RadioButton selected_Gender = sex_RadioGroup.findViewById(genderId);
                    //성별 라디오버튼 체크 안했을 경우
                    if (selected_Gender == null) {
                        Toast.makeText(RegisterActivity.this, "성별을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    //성별까지 모두 다 입력되어 있을경우
                    else {
                        String selectGender = selected_Gender.getText().toString();
                        String url = "http://ykh3587.dothome.co.kr/register.php";

                        ContentValues values = new ContentValues();

                        values.put("userid", txtId);
                        values.put("username", txtName);
                        values.put("email", txtEmail);
                        values.put("password", txtPassword);
                        values.put("mobile", txtPhone);
                        values.put("gender", selectGender);

                        BackgroundTask task = new BackgroundTask(url, values);
                        task.execute();
                    }
                }
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

            asyncDialog = ProgressDialog.show(RegisterActivity.this, "Please Wait", null, true, true);
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

            //register.php파일의 반환값이 "Successfully Registered"와 일치
            if (results.equals("Successfully Registered")) {
                Toast.makeText(RegisterActivity.this, "회원가입 완료!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                RegisterActivity.this.finish();
            }
            //register.php파일의 반환값이 "Successfully Registered"와 불일치
            else {
                Toast.makeText(RegisterActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }
}