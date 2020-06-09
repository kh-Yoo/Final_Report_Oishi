package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Purchase_Page extends AppCompatActivity {

    String phone_number;

    Button PURCHASE;
    Button ALTER_NUMBER;
    Button ALTER_PURCHASE;
    TextView PHONE_NUMBER;
    TextView PURCHASE_SOLUTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase__page);

        PURCHASE = (Button)findViewById(R.id.next_purchase);
        ALTER_NUMBER = (Button)findViewById(R.id.number_alter);
        ALTER_PURCHASE = (Button)findViewById(R.id.purchase_alter);
        PHONE_NUMBER = (TextView)findViewById(R.id.phone_number);
        PURCHASE_SOLUTION = (TextView)findViewById(R.id.purchase_solution);

        phone_number = PHONE_NUMBER.getText().toString();

        PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"결제 완료", Toast.LENGTH_SHORT).show();
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

}
