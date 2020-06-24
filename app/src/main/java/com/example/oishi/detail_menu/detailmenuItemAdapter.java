package com.example.oishi.detail_menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oishi.MainActivity;
import com.example.oishi.R;
import com.example.oishi.detail_menu.model.ParentItem;
import com.example.oishi.purchase.americano;
import com.example.oishi.review.ReviewItem;

import java.util.ArrayList;

public class detailmenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<detailmenuItem> visibleItems = new ArrayList<>();
    public Context context;
    public String storename, foodtype;

    public detailmenuItemAdapter(Context context, String storename, String foodtype){
        this.context = context;
        this.storename = storename;
        this.foodtype = foodtype;
    }

    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.detailmenu_item,  parent, false);
        viewHolder = new ParentItemVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final ParentItemVH parentItemVH = (ParentItemVH)holder;
            parentItemVH.id.setText(visibleItems.get(position).getId());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), americano.class);
                    intent.putExtra("foodname", visibleItems.get(position).getId());
                    intent.putExtra("storename", storename);
                    intent.putExtra("foodtype", foodtype);
                    intent.putExtra("foodprice", visibleItems.get(position).getRating());
                    intent.putExtra("foodimg", visibleItems.get(position).getTime());
                    System.out.println(storename);
                    System.out.println(visibleItems.get(position).getId());
                    System.out.println(visibleItems.get(position).getTime());
                    v.getContext().startActivity(intent);
                }
            });
    }

    static class ParentItemVH extends RecyclerView.ViewHolder {
        TextView content, time, id;
        ImageView rating, rating2, rating3, rating4, rating5;

        ParentItemVH(final View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.item_rating);
            rating2 = itemView.findViewById(R.id.item_rating2);
            rating3 = itemView.findViewById(R.id.item_rating3);
            rating4 = itemView.findViewById(R.id.item_rating4);
            rating5 = itemView.findViewById(R.id.item_rating5);
            content = itemView.findViewById(R.id.item_content);
            time = itemView.findViewById(R.id.item_time);
            id = itemView.findViewById(R.id.item_id);


            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    return false;
                }
            });
        }
    }

    //아이템을 한개 추가해주고싶을때
    public  void addItem(detailmenuItem item){
        visibleItems.add(item);
    }

    //한꺼번에 추가해주고싶을때
    public void addItems(ArrayList<detailmenuItem> items){
        this.visibleItems = items;
    }

}
