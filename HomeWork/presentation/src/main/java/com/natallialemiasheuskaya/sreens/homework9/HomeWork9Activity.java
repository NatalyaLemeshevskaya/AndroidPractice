package com.natallialemiasheuskaya.sreens.homework9;


import com.natallialemiasheuskaya.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.base.BaseViewModel;
import com.natallialemiasheuskaya.sreens.homework1.R;

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
