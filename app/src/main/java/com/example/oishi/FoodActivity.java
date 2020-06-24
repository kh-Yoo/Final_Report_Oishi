package com.example.oishi;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.oishi.food_brand.FoodBrandListFragment;
import com.example.oishi.food_menu.FoodMenuListFragment;
import com.example.oishi.review.PopupActivity;
import com.google.android.material.tabs.TabLayout;

public class FoodActivity extends AppCompatActivity {
    FoodPagerAdapter adapter = new FoodPagerAdapter(getSupportFragmentManager());
    TextView food_Text;
    ScrollView mScrollView;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    public String food_type2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Intent intent = getIntent();
        String food_type = intent.getExtras().getString("food_type");
        if(food_type.equals("분식"))
        {
            food_type2 = "snack_food_menu";
        }
        else if (food_type.equals("카페·디저트"))
        {
            food_type2 = "cafe_menu";
        }
        else if (food_type.equals("한식"))
        {
            food_type2 = "korean_food_menu";
        }
        else if (food_type.equals("패스트푸드"))
        {
            food_type2 = "fast_food_menu";
        }
        else if (food_type.equals("치킨"))
        {
            food_type2 = "chicken_menu";
        }
        else if (food_type.equals("야식"))
        {
            food_type2 = "late_night_food_menu";
        }
        else if (food_type.equals("중국집"))
        {
            food_type2 = "chinese_food_menu";
        }
        else if (food_type.equals("도시락"))
        {
            food_type2 = "lunchbox_menu";
        }
        else if (food_type.equals("피자"))
        {
            food_type2 = "pizza_menu";
        }


        food_Text = findViewById(R.id.food_Text);
        food_Text.setText(food_type);

        mScrollView = findViewById(R.id.food_ScrollView);
        mScrollView.setEnabled(true);

        mViewPager = findViewById(R.id.food_Container);
        setupViewPager(mViewPager, food_type, food_type2);

        mTabLayout = findViewById(R.id.food_TabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    public void setupViewPager(ViewPager viewPager, String food_type, String food_type2) {
        adapter.addFragment("브랜드", new FoodBrandListFragment(food_type, food_type2));
        adapter.addFragment("메뉴", new FoodMenuListFragment(food_type, food_type2));

        viewPager.setAdapter(adapter);
    }
}