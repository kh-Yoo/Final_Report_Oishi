package com.example.oishi.review;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class ReviewRecyclerView extends RecyclerView {
    public ReviewRecyclerView(Context context) {
        super(context);
    }

    public ReviewRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReviewRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }
}
