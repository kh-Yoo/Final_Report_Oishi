package com.example.oishi.menu_sort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oishi.R;

import java.util.ArrayList;

public class MenuSortItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MenuSortItem> visibleItems = new ArrayList<>();

    //정렬 리스트 아이탬 생성 함수
    public MenuSortItemAdapter(String sort1, String sort2, String sort3, String sort4){
        int PARENT_ITEM_VIEW = 0;

        MenuSortItem parentItem1 = new MenuSortItem(sort1, PARENT_ITEM_VIEW);
        visibleItems.add(parentItem1);
        MenuSortItem parentItem2 = new MenuSortItem(sort2, PARENT_ITEM_VIEW);
        visibleItems.add(parentItem2);
        MenuSortItem parentItem3 = new MenuSortItem(sort3, PARENT_ITEM_VIEW);
        visibleItems.add(parentItem3);
        MenuSortItem parentItem4 = new MenuSortItem(sort4, PARENT_ITEM_VIEW);
        visibleItems.add(parentItem4);
    }

    //RecyclerListView 크기 반환
    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return visibleItems.get(position).getViewType();
    }

    //RecyclerListView 생성 동작
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_menu_sort_item, parent, false);
        viewHolder = new ParentItemVH(view);

        return viewHolder;
    }

    //RecyclerListView Item 기능 동작
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ParentItemVH){
            final ParentItemVH parentItemVH = (ParentItemVH)holder;

            parentItemVH.name.setText(visibleItems.get(position).getName());
            parentItemVH.name.setTag(holder);

            parentItemVH.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int holderPosition = ((ParentItemVH)v.getTag()).getAdapterPosition();
                }
            });

            parentItemVH.itemView.setTag(holder);
        }
    }

    //RecyclerView.ViewHolder 생성자
    static class ParentItemVH extends RecyclerView.ViewHolder {
        TextView name;

        ParentItemVH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
        }
    }
}
