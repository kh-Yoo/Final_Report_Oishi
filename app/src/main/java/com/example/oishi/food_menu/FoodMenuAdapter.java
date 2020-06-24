package com.example.oishi.food_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oishi.R;

import java.util.ArrayList;

public class FoodMenuAdapter extends BaseAdapter {

    //FoodMenuAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<FoodMenuListViewItem> foodMenuListViewItems = new ArrayList<>();

    //FoodMenuAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() { return foodMenuListViewItems.size(); }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        //"listview_food_menu_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_menu_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView food_menu_image = convertView.findViewById(R.id.food_menu_image);
        TextView food_menu_name = convertView.findViewById(R.id.food_menu_name);
        TextView food_menu_description = convertView.findViewById(R.id.food_menu_description);

        //Data Set(foodMenuListViewItems)에서 position에 위치한 데이터 참조 획득
        FoodMenuListViewItem foodMenuListViewItem = foodMenuListViewItems.get(position);
        //아이템 내 각 위젯에 데이터 반영
        food_menu_image.setImageResource(context.getResources().getIdentifier(foodMenuListViewItem.getParents_Img(), "drawable", context.getPackageName()));
        food_menu_name.setText(foodMenuListViewItem.getParents_Name());
        food_menu_description.setText(foodMenuListViewItem.getParents_Content());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return foodMenuListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String image, String name, String description) {
        FoodMenuListViewItem item = new FoodMenuListViewItem();

        item.setParents_Img(image);
        item.setParents_Name(name);
        item.setParents_Content(description);

        foodMenuListViewItems.add(item);
    }
}