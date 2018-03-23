package com.natallialemiasheuskaya.presentation.sreens.homework10;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityUserBinding;

public class UserActivity extends BaseMVVMActivity<ActivityUserBinding,UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return new UserViewModel();
    }

}
