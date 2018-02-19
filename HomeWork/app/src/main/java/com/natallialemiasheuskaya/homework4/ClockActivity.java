package com.natallialemiasheuskaya.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.natallialemiasheuskaya.homework1.R;

public class ClockActivity extends AppCompatActivity {

    ClockActivity clockActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
