package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String store_title;
    String menu_title;
    String menu_info; /*String형*/
    String menu_extra_info;
    int total_price; /*Int형*/
    int count_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView TITLE = (TextView)findViewById(R.id.title);
        Button Americano = (Button)findViewById(R.id.americano);
        Button Cafelatte = (Button)findViewById(R.id.cafelatte);
        FloatingActionButton Shopping_Basket_Icon = (FloatingActionButton)findViewById(R.id.shopping_basket_icon);

        store_title = TITLE.getText().toString();

        Americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), americano.class);
                intent.putExtra("store_title", store_title);
                startActivityForResult(intent, 1);
            }
        });
        Cafelatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cafe_latte.class);
                intent.putExtra("store_title", store_title);
                startActivity(intent);
                finish();
            }
        });

        Shopping_Basket_Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set_intent = new Intent(getApplicationContext(), Shopping_basket.class);
                set_intent.putExtra("store_title", store_title);
                set_intent.putExtra("menu_title", menu_title);
                set_intent.putExtra("menu_info", menu_info); /*송신*/
                set_intent.putExtra("menu_extra_info", menu_extra_info);
                set_intent.putExtra("total_price", total_price);
                set_intent.putExtra("count_number", count_number);
                startActivity(set_intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                store_title = data.getStringExtra("store_title");
                menu_title = data.getStringExtra("menu_title");
                menu_info = data.getStringExtra("menu_info"); /*String형*/
                menu_extra_info = data.getStringExtra("menu_extra_info");
                total_price = data.getIntExtra("total_price", 0);/*Int형*/
                count_number = data.getIntExtra("count_number", 0);
            }
        }
    }
}
