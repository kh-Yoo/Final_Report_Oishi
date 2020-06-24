package com.example.oishi.menu_sort;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class MenuSortRecyclerView extends RecyclerView {
    public MenuSortRecyclerView(Context context) {
        super(context);
    }

    public MenuSortRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuSortRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }
}
