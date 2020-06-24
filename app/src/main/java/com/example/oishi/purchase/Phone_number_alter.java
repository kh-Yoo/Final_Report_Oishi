package com.example.oishi.purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oishi.R;

public class Phone_number_alter extends AppCompatActivity {
    String Present_number;
    String Alter_Present_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_alter);

        final TextView PRESENT_NUMBER = findViewById(R.id.present_phone_number);
        final EditText ALTER_NUMBER = findViewById(R.id.new_phone_number);
        Button ALTER_PHONE_NUMBER = findViewById(R.id.alter_phone_number);

        Intent intent = getIntent();
        Present_number = intent.getExtras().getString("present_number");
        PRESENT_NUMBER.setText(Present_number);

        ALTER_PHONE_NUMBER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Alter_Present_number.equals("")) {
                    Toast.makeText( getApplicationContext(), "번호를 입력해주세요!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Alter_Present_number = ALTER_NUMBER.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                    intent.putExtra("alter_phone_number", Alter_Present_number);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }

}
