package com.natallialemiasheuskaya.sreens.homework4;

import android.graphics.drawable.AnimationDrawable;

import android.os.Bundle;
import android.widget.ImageView;

import com.natallialemiasheuskaya.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.sreens.homework1.R;
import com.natallialemiasheuskaya.sreens.homework1.databinding.ActivityClockBinding;

public class ClockActivity extends BaseMVVMActivity<ActivityClockBinding,ClockViewModel> {

    ClockActivity clockActivity;

    ImageView imageOwl;
    AnimationDrawable animationDrawable;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_clock;
    }

    @Override
    public ClockViewModel provideViewModel() {
        return new ClockViewModel();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        imageOwl = (ImageView) findViewById(R.id.owl_with_clock);
        imageOwl.setBackgroundResource(R.drawable.owl_animation);
        animationDrawable = (AnimationDrawable) imageOwl.getBackground();
        animationDrawable.start();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
