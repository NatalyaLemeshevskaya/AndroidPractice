package com.natallialemiasheuskaya.presentation.sreens.homework3;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityHomeWork3Binding;


public class HomeWork3Activity extends BaseMVVMActivity<ActivityHomeWork3Binding,HW3ViewModel> {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work3;
    }

    @Override
    public HW3ViewModel provideViewModel() {
        return new HW3ViewModel();
    }


}
