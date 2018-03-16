package com.natallialemiasheuskaya;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.natallialemiasheuskaya.sreens.homework1.R;
import com.natallialemiasheuskaya.sreens.homework1.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test);


        MyEntity myEntity = new MyEntity("норм","кнопка");


        ActivityTestBinding binding =
        DataBindingUtil.setContentView(this,R.layout.activity_test);
        binding.setMyEntity(myEntity);





    }
}
