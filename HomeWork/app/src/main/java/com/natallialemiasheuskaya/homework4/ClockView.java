package com.natallialemiasheuskaya.homework4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.TimeZone;

public class ClockView extends View{

    private Paint paintClock, paint;
    private float radius;
    private float cx,cy;


    Calendar calendar = Calendar.getInstance();
    int minutes;
    int hours;


    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

        paintClock = new Paint();
        paintClock.setColor(Color.parseColor("#fdd9dae1"));
        paintClock.setStyle(Paint.Style.FILL);
        paintClock.setAntiAlias(true);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setStrokeWidth(10);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w/2;
        cy = h/2;
        radius = w>h?cy:cx;



    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(cx,cy,radius,paintClock);
        canvas.drawCircle(cx,cy,12, paint);

        for(int i= 0; i<12; i++) {
            canvas.rotate(30, cx, cy);
            canvas.drawText(String.valueOf(i+1), cx -10, cy-radius+60, paint);
        }


        calendar.setTimeZone(TimeZone.getTimeZone("GMT+3"));

        int second = calendar.get(Calendar.SECOND);
        minutes = calendar.get(Calendar.MINUTE);

        hours = calendar.get(Calendar.HOUR);

        int min = (360/60)*minutes;
        canvas.save();
        canvas.rotate(min, cx, cy);
        canvas.drawLine(cx, cy, cx, cy-radius+60, paint);
        canvas.restore();


        int hour = (360/12)*hours;
        canvas.save();
        canvas.rotate(hour,cx,cy);
        canvas.drawLine(cx, cy, cx, cy-radius+100, paint);
        canvas.restore();



}



}
