package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class Shopping_basket extends AppCompatActivity {
    int count = 0;
    int first_price;
    int pack_discount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);

        Button COUNT_DOWN = (Button)findViewById(R.id.count_down);
        Button COUNT_UP = (Button)findViewById(R.id.count_up);
        final RadioButton DELIVERYBUTTON = (RadioButton)findViewById(R.id.deliverybutton);
        final RadioButton PACKINGBUTTON = (RadioButton)findViewById(R.id.packingbutton);
        final TextView COUNT_NUMBER = (TextView) findViewById(R.id.count_number);
        TextView STORE_TITLE = (TextView)findViewById(R.id.store_title);
        final TextView MENU_TITLE = (TextView)findViewById(R.id.menu_title);
        TextView MENU_INFO = (TextView)findViewById(R.id.menu_info);
        TextView MENU_EXTRA_INFO = (TextView)findViewById(R.id.menu_extra_info);
        final TextView FIRST_PRICE = (TextView)findViewById(R.id.first_price);
        Button ALLCLEARBUTTON = (Button)findViewById(R.id.Allclearbutton);
        Button CLEARBUTTON = (Button)findViewById(R.id.Clearbutton);
        final LinearLayout MENU_INFORMATION = (LinearLayout)findViewById(R.id.menu_information);
        Button NEXT_PURCHASE = (Button)findViewById(R.id.next_purchase);


        Intent get_intent = getIntent(); /*데이터 수신*/
        String store_title = get_intent.getExtras().getString("store_title");
        String menu_title = get_intent.getExtras().getString("menu_title");
        String menu_info = get_intent.getExtras().getString("menu_info"); /*String형*/
        String menu_extra_info = get_intent.getExtras().getString("menu_extra_info");
        first_price = get_intent.getExtras().getInt("total_price"); /*Int형*/
        int count_number = get_intent.getExtras().getInt("count_number");

        count = count_number;

        COUNT_NUMBER.setText(""+count);

        DELIVERYBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PACKINGBUTTON.setChecked(false);
                pack_discount = 0;
                FIRST_PRICE.setText(""+((first_price * count) + pack_discount)+"원");
            }
        });

        PACKINGBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DELIVERYBUTTON.setChecked(false);
                pack_discount = -1000;
                FIRST_PRICE.setText(""+((first_price * count) + pack_discount)+"원");
            }
        });

        COUNT_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                COUNT_NUMBER.setText("" + count);
                FIRST_PRICE.setText(""+((first_price * count) + pack_discount)+"원");
            }
        });

        COUNT_DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count < 1)
                {count = 1;}

                COUNT_NUMBER.setText("" + count);
                FIRST_PRICE.setText(""+((first_price * count ) + pack_discount)+"원");
            }
        });

        CLEARBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MENU_INFORMATION.setVisibility(View.INVISIBLE);
            }
        });

        NEXT_PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                startActivity(intent);
            }
        });

        STORE_TITLE.setText(store_title);
        MENU_TITLE.setText(menu_title);
        MENU_INFO.setText(menu_info);
        MENU_EXTRA_INFO.setText(menu_extra_info);
        FIRST_PRICE.setText(""+((first_price * count) + pack_discount)+"원");
    }
}
