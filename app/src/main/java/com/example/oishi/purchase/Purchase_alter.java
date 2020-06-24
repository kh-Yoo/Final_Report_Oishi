package com.example.oishi.purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oishi.R;

public class Purchase_alter extends AppCompatActivity {
    Button PAY;
    Button CARD;
    String purchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_alter);

        final Button mobilepay = findViewById(R.id.mobile_phone_payment);
        PAY = findViewById(R.id.samsung_pay);
        CARD = findViewById(R.id.credit_card_payment);
        final Button ALTER_BILL = findViewById(R.id.pay_in_cash);
        final Button ALTER_CARD = findViewById(R.id.pay_in_card);

        ALTER_BILL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                purchase = ALTER_BILL.getText().toString();
                intent.putExtra("purchase", purchase);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        mobilepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                purchase = mobilepay.getText().toString();
                intent.putExtra("purchase", purchase);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


        ALTER_CARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                purchase = ALTER_CARD.getText().toString();
                intent.putExtra("purchase", purchase);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        PAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                purchase = PAY.getText().toString();
                intent.putExtra("purchase", purchase);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        CARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                purchase = CARD.getText().toString();
                intent.putExtra("purchase", purchase);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
