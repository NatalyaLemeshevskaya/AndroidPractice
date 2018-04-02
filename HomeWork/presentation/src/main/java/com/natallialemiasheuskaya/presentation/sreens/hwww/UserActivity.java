package com.natallialemiasheuskaya.presentation.sreens.hwww;


import android.os.Bundle;

import com.natallialemiasheuskaya.retrofit.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.retrofit.databinding.UserActivityBinding;

public class UserActivity extends BaseMVVMActivity<UserActivityBinding,UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.user_activity;
    }

    @Override
    public UserViewModel provideViewModel() {
        return new UserViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
