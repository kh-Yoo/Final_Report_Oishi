package com.example.buy_and_purchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class americano extends AppCompatActivity {

    int count = 0;
    int total_price = 0;
    int base_price = 0;
    String store_title;
    String menu_title;
    String menu_info;
    String menu_extra_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        final RadioButton HOTBUTTON = (RadioButton)findViewById(R.id.hotbutton);
        final RadioButton ICEBUTTON = (RadioButton)findViewById(R.id.icebutton);
        final CheckBox BIGSIZEBUTTON = (CheckBox)findViewById(R.id.bigsizebutton);
        final RadioButton SHOTBUTTON = (RadioButton)findViewById(R.id.shotbutton);
        final RadioButton SYRUPBUTTON = (RadioButton)findViewById(R.id.syrupbutton);
        final RadioButton NOBUTTON = (RadioButton)findViewById(R.id.notbutton);
        Button COUNT_DOWN = (Button)findViewById(R.id.count_down);
        Button COUNT_UP = (Button)findViewById(R.id.count_up);
        final TextView COUNT_NUMBER = (TextView) findViewById(R.id.count_number);
        Button COFFEE_BUY = (Button)findViewById(R.id.coffee_purchase);
        final TextView BASE_PRICE = (TextView)findViewById(R.id.menu_base_price);
        final TextView BIGSIZE_EXTRA_PRICE = (TextView)findViewById(R.id.bigsize_extra_price);
        final TextView SHOT_EXTRA_PRICE = (TextView)findViewById(R.id.shot_extra_price);
        final TextView SYRUP_EXTRA_PRICE = (TextView)findViewById(R.id.syrup_extra_price);
        final TextView HOT_TEXT = (TextView)findViewById(R.id.hottext);
        final TextView ICE_TEXT = (TextView)findViewById(R.id.icetext);
        final TextView BIGSIZE_TEXT = (TextView)findViewById(R.id.bigsizetext);
        final TextView SYRUP_TEXT = (TextView)findViewById(R.id.syruptext);
        final TextView SHOT_TEXT = (TextView)findViewById(R.id.shottext);
        final TextView TITLE = (TextView)findViewById(R.id.title);

        Intent get_intent = getIntent(); /*데이터 수신*/
        store_title = get_intent.getExtras().getString("store_title");

        HOTBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ICEBUTTON.setChecked(false);
            }
        });

        ICEBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HOTBUTTON.setChecked(false);
            }
        });

        BIGSIZEBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HOTBUTTON.isChecked() == false && ICEBUTTON.isChecked() == false)
                {
                    Toast.makeText(getApplicationContext() , "음료를 선택해주세요.", Toast.LENGTH_LONG).show();
                    BIGSIZEBUTTON.setChecked(false);
                }
            }
        });

        SYRUPBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NOBUTTON.setChecked(false);
            }
        });

        SHOTBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NOBUTTON.setChecked(false);
            }
        });

        NOBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SYRUPBUTTON.setChecked(false);
                SHOTBUTTON.setChecked(false);
            }
        });

        COUNT_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                COUNT_NUMBER.setText("" + count);
            }
        });

        COUNT_DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count < 0)
                {count = 0;}

                COUNT_NUMBER.setText("" + count);
            }
        });

        COFFEE_BUY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count < 1)
                {
                    Toast.makeText(getApplicationContext() , "주문할 물건을 1개 이상 담아주세요.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    total_price = Integer.parseInt(BASE_PRICE.getText().toString());
                    if(HOTBUTTON.isChecked() == true)
                    {
                        menu_info = HOT_TEXT.getText().toString();
                    }
                    if(ICEBUTTON.isChecked() == true)
                    {
                        menu_info = ICE_TEXT.getText().toString();
                    }
                    if(BIGSIZEBUTTON.isChecked() == true)
                    {
                        total_price = total_price + Integer.parseInt(BIGSIZE_EXTRA_PRICE.getText().toString());
                        menu_info = menu_info + "(" + BIGSIZE_TEXT.getText().toString() + ")";
                    }
                    if(SHOTBUTTON.isChecked() == true && SYRUPBUTTON.isChecked() == true)
                    {
                        total_price = total_price + Integer.parseInt(SYRUP_EXTRA_PRICE.getText().toString());
                        total_price = total_price + Integer.parseInt(SHOT_EXTRA_PRICE.getText().toString());
                        menu_extra_info =  SYRUP_TEXT.getText().toString() + ", " + SHOT_TEXT.getText().toString();
                    }
                    if(SHOTBUTTON.isChecked() == true)
                    {
                        total_price = total_price + Integer.parseInt(SHOT_EXTRA_PRICE.getText().toString());
                        menu_extra_info = SHOT_TEXT.getText().toString();
                    }
                    if(SYRUPBUTTON.isChecked() == true)
                    {
                        total_price = total_price + Integer.parseInt(SYRUP_EXTRA_PRICE.getText().toString());
                        menu_extra_info = SYRUP_TEXT.getText().toString();
                    }

                    if(HOTBUTTON.isChecked() == false && ICEBUTTON.isChecked() == false)
                    {
                        Toast.makeText(getApplicationContext() , "음료를 선택해주세요.", Toast.LENGTH_LONG).show();
                    }

                    menu_title = TITLE.getText().toString();
                    base_price = Integer.parseInt(BASE_PRICE.getText().toString());


                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("store_title", store_title);
                    intent.putExtra("menu_title", menu_title);
                    intent.putExtra("menu_info", menu_info); /*송신*/
                    intent.putExtra("menu_extra_info", menu_extra_info);
                    intent.putExtra("total_price", total_price);
                    intent.putExtra("count_number", count);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
