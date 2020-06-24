package com.example.oishi.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oishi.R;

import java.util.ArrayList;

public class ReviewItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<ReviewItem> visibleItems = new ArrayList<>();
    Context context;

    public ReviewItemAdapter(Context context){
        this.context = context;

    }

    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.review_item,  parent, false);
        viewHolder = new ParentItemVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ParentItemVH){
            final ParentItemVH parentItemVH = (ParentItemVH)holder;
            parentItemVH.id.setText(visibleItems.get(position).getId());
            parentItemVH.content.setText(visibleItems.get(position).getContent());
            parentItemVH.time.setText(visibleItems.get(position).getTime());
            if(visibleItems.get(position).getRating() == "1") {
                parentItemVH.rating.setImageResource(R.drawable.ic_star_black_24dp);
            }
            else if(visibleItems.get(position).getRating() == "2") {
                parentItemVH.rating.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating2.setImageResource(R.drawable.ic_star_black_24dp);
            }
            else if(visibleItems.get(position).getRating() == "3") {
                parentItemVH.rating.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating2.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating3.setImageResource(R.drawable.ic_star_black_24dp);
            }
            else if(visibleItems.get(position).getRating() == "4") {
                parentItemVH.rating.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating2.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating3.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating4.setImageResource(R.drawable.ic_star_black_24dp);
            }
            else if(visibleItems.get(position).getRating() == "5") {
                parentItemVH.rating.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating2.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating3.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating4.setImageResource(R.drawable.ic_star_black_24dp);
                parentItemVH.rating5.setImageResource(R.drawable.ic_star_black_24dp);
            }
        }
    }

    static class ParentItemVH extends RecyclerView.ViewHolder {
        TextView content, time, id;
        ImageView rating, rating2, rating3, rating4, rating5;

        ParentItemVH(View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.item_rating);
            rating2 = itemView.findViewById(R.id.item_rating2);
            rating3 = itemView.findViewById(R.id.item_rating3);
            rating4 = itemView.findViewById(R.id.item_rating4);
            rating5 = itemView.findViewById(R.id.item_rating5);
            content = itemView.findViewById(R.id.item_content);
            time = itemView.findViewById(R.id.item_time);
            id = itemView.findViewById(R.id.item_id);
        }
    }

    //아이템을 한개 추가해주고싶을때
    public  void addItem(ReviewItem item){
        visibleItems.add(item);
    }

    //한꺼번에 추가해주고싶을때
    public void addItems(ArrayList<ReviewItem> items){
        this.visibleItems = items;
    }


}
