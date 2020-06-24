package com.example.oishi.review;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oishi.FoodDetailActivity;
import com.example.oishi.MainActivity;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.main_fragment.ReviewFragment;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PopupActivity extends AppCompatActivity {
    EditText r_id;
    EditText r_content;
    String id;
    String name;
    String content;
    int numStar;
    String Brand_Name;
    String starpoint;
    private RatingBar ratingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupactivity);

        r_id = (EditText)findViewById(R.id.re_review_id);
        r_content = (EditText) findViewById(R.id.re_review_content);

        long now = System.currentTimeMillis();
        Date mDate = new Date(now);

        SimpleDateFormat simpleDate = new SimpleDateFormat("yy-MM-dd hh:mm");
        final String PRESENT_Time = simpleDate.format(mDate);

        ratingbar = findViewById(R.id.rating);

        ratingbar.setOnRatingBarChangeListener(new Listener());

        //확인버튼 이벤트
        Button button_ok = (Button) findViewById(R.id.bt_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://ykh3587.dothome.co.kr/reviewregister.php";
                id = r_id.getText().toString();
                content = r_content.getText().toString();
                ContentValues values = new ContentValues();
                values.put("id", id);
                values.put("content", content);
                values.put("time", PRESENT_Time);
                values.put("rating", starpoint);
                BackgroundTask task = new BackgroundTask(url, values);
                task.execute();
            }
        });
    }

    class Listener implements RatingBar.OnRatingBarChangeListener
    {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingbar.setRating(rating);
            numStar = ratingbar.getNumStars();
            starpoint = String.valueOf(numStar);
        }
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

            asyncDialog = ProgressDialog.show(PopupActivity.this, "Please Wait", null, true, true);
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
                Toast.makeText(PopupActivity.this, "댓글 등록 완료!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
            //register.php파일의 반환값이 "Successfully Registered"와 불일치
            else {
                Toast.makeText(PopupActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
