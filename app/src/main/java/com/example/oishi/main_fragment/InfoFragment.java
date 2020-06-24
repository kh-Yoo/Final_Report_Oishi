package com.example.oishi.main_fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oishi.R;

public class InfoFragment extends Fragment {

    Bundle bundle;

    public InfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        TextView main_store_order_number_Text = view.findViewById(R.id.main_store_order_number_Text);
        TextView main_store_review_Text = view.findViewById(R.id.main_store_review_Text);
        TextView main_store_favorite_Text = view.findViewById(R.id.main_store_favorite_Text);
        TextView main_store_min_price_Text = view.findViewById(R.id.main_store_min_price_Text);
        TextView main_store_delivery_tip_Text = view.findViewById(R.id.main_store_delivery_tip_Text);
        TextView main_store_running_time_text = view.findViewById(R.id.main_store_running_time_text);
        TextView main_store_holiday_text = view.findViewById(R.id.main_store_holiday_text);
        TextView main_store_phone_number_Text = view.findViewById(R.id.main_store_phone_number_Text);

        int order_number = 0, review = 0, favorite = 0, min_price = 0, delivery_tip = 0;
        String running_time = null, holiday = null, phone_number = null;

        bundle = getArguments();
        if(bundle != null) {
            order_number = bundle.getInt("order_number");
            review = bundle.getInt("review");
            favorite = bundle.getInt("favorite");
            min_price = bundle.getInt("min_price");
            delivery_tip = bundle.getInt("delivery_tip");
            running_time = bundle.getString("running_time");
            holiday = bundle.getString("holiday");
            phone_number = bundle.getString("phone_number");
        }

        //최근 주문수
        main_store_order_number_Text.setText(String.format("%s+", order_number));
        //전체 리뷰수
        main_store_review_Text.setText(String.format("%s+", review));
        //찜
        main_store_favorite_Text.setText(String.format("%s", favorite));
        //최소 주문 금액
        main_store_min_price_Text.setText(setMinPriceText(min_price));
        //배달 팁
        main_store_delivery_tip_Text.setText(setDeliveryTipText(delivery_tip));
        //운영 시간
        main_store_running_time_text.setText(String.format("%s", running_time));
        //휴무일
        main_store_holiday_text.setText(String.format("%s", holiday));
        //전화 번호
        main_store_phone_number_Text.setText(String.format("%s", phone_number));

        return view;
    }

    private String setMinPriceText(int Min_Price) {
        //가게 최소주문금액
        int min_price_Thousands = Min_Price/1000;
        int min_price_Hundred = Min_Price%1000;
        if(min_price_Hundred == 0) {
            return String.format("%s,000원 이상", min_price_Thousands);
        }
        else {
            return String.format("%s,%s원 이상", min_price_Thousands, min_price_Hundred);
        }
    }

    private String setDeliveryTipText(int Delivery_Tip) {
        //배달팁이 0원일때
        if(Delivery_Tip == 0) {
            return "무료";
        }
        //배달팁이 0원이 아닐때
        else {
            int delivery_tip_Thousands = Delivery_Tip/1000;
            int delivery_tip_Hundred = Delivery_Tip%1000;
            //배달팁의 백원 단위가 0일때
            if(delivery_tip_Hundred == 0) {
                return String.format("%s,000원", delivery_tip_Thousands);
            }
            //배달팁의 백원 단위가 0이 아닐떄
            else {
                return String.format("%s,%s원", delivery_tip_Thousands, delivery_tip_Hundred);
            }
        }
    }
}