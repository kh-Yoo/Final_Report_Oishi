package com.example.oishi.detail_menu;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class detailmenuRecyclerView extends RecyclerView {
    public detailmenuRecyclerView(Context context) {
        super(context);
    }

    public detailmenuRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public detailmenuRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }
}
