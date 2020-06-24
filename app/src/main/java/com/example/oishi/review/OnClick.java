package com.example.oishi.review;

import android.view.View;

interface OnClick {
    void onClick(View v);

    public interface OnClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        void onClick(View v);
    }
}
