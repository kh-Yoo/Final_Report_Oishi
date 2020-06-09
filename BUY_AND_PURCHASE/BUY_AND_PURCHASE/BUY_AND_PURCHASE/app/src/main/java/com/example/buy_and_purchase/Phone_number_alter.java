package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Phone_number_alter extends AppCompatActivity {
    String Present_number;
    String Alter_Present_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_alter);

        final TextView PRESENT_NUMBER = (TextView)findViewById(R.id.present_Number);
        final EditText ALTER_NUMBER = (EditText)findViewById(R.id.alter_number);
        Button ALTER_PHONE_NUMBER = (Button)findViewById(R.id.alter_phone_number);

        Intent intent = getIntent();
        Present_number = intent.getExtras().getString("present_number");
        PRESENT_NUMBER.setText(Present_number);

        ALTER_PHONE_NUMBER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Alter_Present_number == "")
                {
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
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }

}
