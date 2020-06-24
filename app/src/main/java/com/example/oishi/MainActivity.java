package com.example.oishi;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.oishi.main_fragment.FavoriteFragment;
import com.example.oishi.main_fragment.HomeFragment;
import com.example.oishi.main_fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_Navigation);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new HomeFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.home_item:
                        fragment = new HomeFragment();
                        break;
                    case R.id.heart_item:
                        fragment = new FavoriteFragment();
                        break;
                    case R.id.myuser_item:
                        fragment = new UserFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,fragment).commit();
                return true;
            }
        });
    }
}
