package com.example.oishi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
    }
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomTextView);

            Drawable drawableStart = null;
            Drawable drawableEnd = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            final int drawableStartId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableStartCompat, -1);
            final int drawableEndId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableEndCompat, -1);
            final int drawableBottomId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableBottomCompat, -1);
            final int drawableTopId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableTopCompat, -1);

            if (drawableStartId != -1)
                drawableStart = AppCompatResources.getDrawable(context, drawableStartId);
            if (drawableEndId != -1)
                drawableEnd = AppCompatResources.getDrawable(context, drawableEndId);
            if (drawableBottomId != -1)
                drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
            if (drawableTopId != -1)
                drawableTop = AppCompatResources.getDrawable(context, drawableTopId);

            // to support rtl
            setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);
            attributeArray.recycle();
        }
    }
}