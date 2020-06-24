package com.example.oishi.purchase;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class PurchaseRecyclerView extends RecyclerView {
    public PurchaseRecyclerView(Context context) {
        super(context);
    }

    public PurchaseRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PurchaseRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }
}
