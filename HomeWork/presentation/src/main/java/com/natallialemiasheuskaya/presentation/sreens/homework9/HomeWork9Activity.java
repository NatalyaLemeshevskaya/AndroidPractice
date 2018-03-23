package com.natallialemiasheuskaya.presentation.sreens.homework9;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;

public class HomeWork9Activity extends BaseMVVMActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work9;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return new User9ViewModel();
    }

}
