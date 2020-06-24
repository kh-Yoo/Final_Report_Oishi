package com.example.oishi.search;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oishi.R;

public class SearchActivity extends AppCompatActivity {
    //검색 EditText
    SearchView search_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_view = findViewById(R.id.search_view);
        search_view.setIconified(false);

        search_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_view.onActionViewExpanded();
            }
        });

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 입력받은 문자열 처리
                Toast.makeText(getApplicationContext(), "검색어 : "+query,Toast.LENGTH_SHORT).show();
                //저장
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 입력란의 문자열이 바뀔 때 처리
                return false;
            }
        });
    }
}