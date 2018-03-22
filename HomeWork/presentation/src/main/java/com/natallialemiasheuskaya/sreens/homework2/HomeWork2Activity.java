package com.natallialemiasheuskaya.sreens.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.natallialemiasheuskaya.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.base.BaseViewModel;
import com.natallialemiasheuskaya.sreens.homework1.R;

public class HomeWork2Activity extends BaseMVVMActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work2;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return new HW2ViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
