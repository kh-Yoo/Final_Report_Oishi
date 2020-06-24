package com.example.oishi.menu_sort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oishi.R;
import com.example.oishi.food_brand.FoodBrandListFragment;

public class FoodMenuSortActivity extends AppCompatActivity {

    TextView food_menu_Text;
    Button sort_Button1, sort_Button2, sort_Button3, sort_Button4;
    MenuSortRecyclerView recyclerView1, recyclerView2;
    MenuSortItemAdapter adapter1, adapter2, adapter3, adapter4;
    ScrollView food_menu_sort_ScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_sort);

        Intent intent = getIntent();
        String menu_name = intent.getExtras().getString("menu_name");

        food_menu_Text = findViewById(R.id.food_menu_Text);
        food_menu_Text.setText(menu_name);

        food_menu_sort_ScrollView = findViewById(R.id.food_menu_sort_ScrollView);
        food_menu_sort_ScrollView.setEnabled(true);

        sort_Button1 = findViewById(R.id.sort_Button1);
        sort_Button2 = findViewById(R.id.sort_Button2);
        sort_Button3 = findViewById(R.id.sort_Button3);
        sort_Button4 = findViewById(R.id.sort_Button4);

        recyclerView1 = findViewById(R.id.recyclerview1);
        recyclerView2 = findViewById(R.id.recyclerview2);

        sort_Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모든 버튼이 눌러지지 않은 상태
                if (adapter1 == null && adapter2 == null && adapter3 == null && adapter4 == null) {
                    sort_Button1.setBackgroundResource(R.color.powder_blue);
                    sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                    adapter1 = new MenuSortItemAdapter("기본순", "주문 많은 순", "별점 높은 순", "찜 많은 순");
                    recyclerView1.setAdapter(adapter1);
                    recyclerView1.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                    recyclerView1.setVisibility(View.VISIBLE);
                }
                //어느 버튼 눌러져있는 상태
                else {
                    //버튼 1이 눌러져있는 경우
                    if (adapter1 != null) {
                        adapter1 = null;
                        sort_Button1.setBackgroundResource(R.color.light_cyan);
                        sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        recyclerView1.setVisibility(View.GONE);
                    } else {
                        //버튼 2가 눌러져있는 경우
                        if (adapter2 != null && adapter3 == null && adapter4 == null) {
                            adapter2 = null;
                            sort_Button2.setBackgroundResource(R.color.light_cyan);
                            sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        }
                        //버튼 3이 눌러져있는 경우
                        else if (adapter2 == null && adapter3 != null && adapter4 == null) {
                            adapter3 = null;
                            sort_Button3.setBackgroundResource(R.color.light_cyan);
                            sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView2.setVisibility(View.GONE);
                        }
                        //버튼 4가 눌러져있는 경우
                        else if (adapter2 == null && adapter3 == null) {
                            adapter4 = null;
                            sort_Button4.setBackgroundResource(R.color.light_cyan);
                            sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView2.setVisibility(View.GONE);
                        }
                        sort_Button1.setBackgroundResource(R.color.powder_blue);
                        sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                        adapter1 = new MenuSortItemAdapter("기본순", "주문 많은 순", "별점 높은 순", "찜 많은 순");
                        recyclerView1.setAdapter(adapter1);
                        recyclerView1.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                        recyclerView1.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        sort_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모든 버튼이 눌러지지 않은 상태
                if (adapter1 == null && adapter2 == null && adapter3 == null && adapter4 == null) {
                    sort_Button2.setBackgroundResource(R.color.powder_blue);
                    sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                    adapter2 = new MenuSortItemAdapter("전체", "4.5점 이상", "4.0점 이상", "3.5점 이상");
                    recyclerView1.setAdapter(adapter2);
                    recyclerView1.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                    recyclerView1.setVisibility(View.VISIBLE);
                }
                //어느 버튼 눌러져있는 상태
                else {
                    //버튼 2가 눌러져있는 경우
                    if (adapter2 != null) {
                        adapter2 = null;
                        sort_Button2.setBackgroundResource(R.color.light_cyan);
                        sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        recyclerView1.setVisibility(View.GONE);
                    } else {
                        //버튼 1이 눌러져있는 경우
                        if (adapter1 != null && adapter3 == null && adapter4 == null) {
                            adapter1 = null;
                            sort_Button1.setBackgroundResource(R.color.light_cyan);
                            sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        }
                        //버튼 3이 눌러져있는 경우
                        else if (adapter1 == null && adapter3 != null && adapter4 == null) {
                            adapter3 = null;
                            sort_Button3.setBackgroundResource(R.color.light_cyan);
                            sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView2.setVisibility(View.GONE);
                        }
                        //버튼 4가 눌러져있는 경우
                        else if (adapter1 == null && adapter3 == null) {
                            adapter4 = null;
                            sort_Button4.setBackgroundResource(R.color.light_cyan);
                            sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView2.setVisibility(View.GONE);
                        }
                        sort_Button2.setBackgroundResource(R.color.powder_blue);
                        sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                        adapter2 = new MenuSortItemAdapter("전체", "4.5점 이상", "4.0점 이상", "3.5점 이상");
                        recyclerView1.setAdapter(adapter2);
                        recyclerView1.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                        recyclerView1.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        sort_Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모든 버튼이 눌러지지 않은 상태
                if (adapter1 == null && adapter2 == null && adapter3 == null && adapter4 == null) {
                    sort_Button3.setBackgroundResource(R.color.powder_blue);
                    sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                    adapter3 = new MenuSortItemAdapter("전체", "5,000원 이하", "10,000원 이하", "15,000원 이하");
                    recyclerView2.setAdapter(adapter3);
                    recyclerView2.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                    recyclerView2.setVisibility(View.VISIBLE);
                }
                //어느 버튼 눌러져있는 상태
                else {
                    //버튼 3이 눌러져있는 경우
                    if (adapter3 != null) {
                        adapter3 = null;
                        sort_Button3.setBackgroundResource(R.color.light_cyan);
                        sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        recyclerView2.setVisibility(View.GONE);
                    } else {
                        //버튼 1이 눌러져있는 경우
                        if (adapter1 != null && adapter2 == null && adapter4 == null) {
                            adapter1 = null;
                            sort_Button1.setBackgroundResource(R.color.light_cyan);
                            sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView1.setVisibility(View.GONE);
                        }
                        //버튼 2가 눌러져있는 경우
                        else if (adapter1 == null && adapter2 != null && adapter4 == null) {
                            adapter2 = null;
                            sort_Button2.setBackgroundResource(R.color.light_cyan);
                            sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView1.setVisibility(View.GONE);
                        }
                        //버튼 4가 눌러져있는 경우
                        else if (adapter1 == null && adapter2 == null) {
                            adapter4 = null;
                            sort_Button4.setBackgroundResource(R.color.light_cyan);
                            sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        }
                        sort_Button3.setBackgroundResource(R.color.powder_blue);
                        sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                        adapter3 = new MenuSortItemAdapter("전체", "5,000원 이하", "10,000원 이하", "15,000원 이하");
                        recyclerView2.setAdapter(adapter3);
                        recyclerView2.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                        recyclerView2.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        sort_Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모든 버튼이 눌러지지 않은 상태
                if (adapter1 == null && adapter2 == null && adapter3 == null && adapter4 == null) {
                    sort_Button4.setBackgroundResource(R.color.powder_blue);
                    sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                    adapter4 = new MenuSortItemAdapter("전체", "무료", "2,000원 이하", "3,000원 이하");
                    recyclerView2.setAdapter(adapter4);
                    recyclerView2.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                    recyclerView2.setVisibility(View.VISIBLE);
                }
                //어느 버튼 눌러져있는 상태
                else {
                    //버튼 4가 눌러져있는 경우
                    if (adapter4 != null) {
                        adapter4 = null;
                        sort_Button4.setBackgroundResource(R.color.light_cyan);
                        sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        recyclerView2.setVisibility(View.GONE);
                    } else {
                        //버튼 1이 눌러져있는 경우
                        if (adapter1 != null && adapter2 == null && adapter3 == null) {
                            adapter1 = null;
                            sort_Button1.setBackgroundResource(R.color.light_cyan);
                            sort_Button1.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView1.setVisibility(View.GONE);
                        }
                        //버튼 2가 눌러져있는 경우
                        else if (adapter1 == null && adapter2 != null && adapter3 == null) {
                            adapter2 = null;
                            sort_Button2.setBackgroundResource(R.color.light_cyan);
                            sort_Button2.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                            recyclerView1.setVisibility(View.GONE);
                        }
                        //버튼 3이 눌러져있는 경우
                        else if (adapter1 == null && adapter2 == null) {
                            adapter3 = null;
                            sort_Button3.setBackgroundResource(R.color.light_cyan);
                            sort_Button3.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_add_black_24dp), null);
                        }
                        sort_Button4.setBackgroundResource(R.color.powder_blue);
                        sort_Button4.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_remove_black_24dp), null);
                        adapter4 = new MenuSortItemAdapter("전체", "무료", "2,000원 이하", "3,000원 이하");
                        recyclerView2.setAdapter(adapter4);
                        recyclerView2.setLayoutManager(new MenuSortItemLayoutManager(FoodMenuSortActivity.this));
                        recyclerView2.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }
}