package com.example.dariamultiautocompletetextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DariaMultiAutoCompleteTextview extends androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView implements OnCountListener {

    private static final int MARGIN = 10;
    private static final int PADDING = MARGIN * 4;
    private static final int RADIUS = 20;
    Paint counterPaint;
    Paint backgroundPaint;
    Canvas canvas;
    int count;
    TypedArray typedArray;

    public DariaMultiAutoCompleteTextview(@NonNull Context context) {
        super(context);
        init(null, context);
    }

    public DariaMultiAutoCompleteTextview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context);
    }


    public DariaMultiAutoCompleteTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, context);
    }

    @Override
    public void setBackgroundDrawable(@Nullable Drawable background) {
        //comment
    }

    private void init(@Nullable AttributeSet attrs, Context context) {

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.DariaMultiAutoCompleteTextview);


        backgroundPaint = new Paint();
        backgroundPaint.setColor(typedArray.getColor(R.styleable.DariaMultiAutoCompleteTextview_daria_border_color, Color.BLACK));
        backgroundPaint.setStrokeWidth(5);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        counterPaint = new Paint();
        counterPaint.setColor(Color.RED);
        counterPaint.setStyle(Paint.Style.FILL);
        counterPaint.setTextSize(typedArray.getInt(R.styleable.DariaMultiAutoCompleteTextview_daria_counter_size, 40));
        counterPaint.setTextAlign(Paint.Align.RIGHT);
    }

    @Override
    protected MovementMethod getDefaultMovementMethod() {
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        setPadding(PADDING, PADDING, PADDING, PADDING);
        canvas.drawRoundRect(MARGIN, MARGIN, getWidth() - MARGIN, getHeight() - MARGIN, RADIUS, RADIUS, backgroundPaint);
        if (typedArray.getBoolean(R.styleable.DariaMultiAutoCompleteTextview_daria_counter_visibility, false)) {
            canvas.drawText(count + "", getWidth() - (MARGIN + PADDING), getHeight() - (PADDING), counterPaint);
            invalidate();
        }
    }

    @Override
    public void OnCountChanged(int count) {
        this.count = count;
    }

    public OnCountListener getOnCountListener() {
        return this;
    }
}
