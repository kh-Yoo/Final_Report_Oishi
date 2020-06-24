package com.example.oishi.main_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.oishi.FoodActivity;
import com.example.oishi.R;
import com.example.oishi.map.Real_Write_Address;
import com.example.oishi.search.SearchActivity;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView user_address_Text = view.findViewById(R.id.user_address_Text);

        ImageButton korean_food_button = view.findViewById(R.id.korean_food_button);
        ImageButton snack_food_button = view.findViewById(R.id.snack_food_button);
        ImageButton cafe_button = view.findViewById(R.id.cafe_button);
        ImageButton chicken_button = view.findViewById(R.id.chicken_button);
        ImageButton pizza_button = view.findViewById(R.id.pizza_button);
        ImageButton fast_food_button = view.findViewById(R.id.fast_food_button);
        ImageButton chinese_food_button = view.findViewById(R.id.chinese_food_button);
        ImageButton late_night_food_button = view.findViewById(R.id.late_night_food_button);
        ImageButton lunchbox_button = view.findViewById(R.id.lunchbox_button);

        Button search_Button = view.findViewById(R.id.search_Button);

        final Intent[] intent = new Intent[3];
        intent[0] = new Intent(getActivity(), Real_Write_Address.class);
        intent[1] = new Intent(getActivity(), FoodActivity.class);
        intent[2] = new Intent(getActivity(), SearchActivity.class);

        user_address_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent[0]);
            }
        });

        korean_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.korean_food));
                startActivity(intent[1]);
            }
        });
        snack_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.snack_food));
                startActivity(intent[1]);
            }
        });
        cafe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.cafe));
                startActivity(intent[1]);
            }
        });
        chicken_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.chicken));
                startActivity(intent[1]);
            }
        });
        pizza_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.pizza));
                startActivity(intent[1]);
            }
        });
        fast_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.fast_food));
                startActivity(intent[1]);
            }
        });
        chinese_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.chinese_food));
                startActivity(intent[1]);
            }
        });
        late_night_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.late_night_food));
                startActivity(intent[1]);
            }
        });
        lunchbox_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent[1].putExtra("food_type", getString(R.string.lunchbox));
                startActivity(intent[1]);
            }
        });

        search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent[2]);
            }
        });

        return view;
    }
}