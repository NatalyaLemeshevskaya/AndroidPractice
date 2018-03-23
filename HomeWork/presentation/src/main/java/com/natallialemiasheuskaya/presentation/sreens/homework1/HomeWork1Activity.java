package com.natallialemiasheuskaya.presentation.sreens.homework1;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityHomeWork1Binding;

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
