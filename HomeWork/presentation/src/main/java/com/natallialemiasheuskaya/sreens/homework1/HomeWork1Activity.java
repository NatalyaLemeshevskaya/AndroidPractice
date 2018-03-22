package com.natallialemiasheuskaya.sreens.homework1;


import com.natallialemiasheuskaya.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.sreens.homework1.databinding.ActivityHomeWork1Binding;

public class HomeWork1Activity extends BaseMVVMActivity<ActivityHomeWork1Binding,HW1ViewModel>{


    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work1;
    }

    @Override
    public HW1ViewModel provideViewModel() {
        return new HW1ViewModel();
    }

}
