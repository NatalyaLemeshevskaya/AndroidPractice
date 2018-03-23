package com.natallialemiasheuskaya.presentation.sreens.homework2;

import android.os.Bundle;

import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;

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
