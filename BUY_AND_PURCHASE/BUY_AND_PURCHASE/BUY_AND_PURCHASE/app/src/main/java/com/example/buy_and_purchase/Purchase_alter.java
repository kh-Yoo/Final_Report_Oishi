package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Purchase_alter extends AppCompatActivity {

    String purchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_alter);

        final Button ALTER_BILL = (Button)findViewById(R.id.bill_purchase);
        final Button ALTER_CARD = (Button)findViewById(R.id.card_purchase);

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
    }
}
