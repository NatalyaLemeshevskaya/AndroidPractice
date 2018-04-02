package com.natallialemiasheuskaya.presentation.sreens.hwww;

import android.os.Bundle;

import com.natallialemiasheuskaya.retrofit.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.retrofit.databinding.ActivityEditBinding;


public class EditActivity extends BaseMVVMActivity<ActivityEditBinding,EditViewModel>{

    @Override
    public int provideLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    public EditViewModel provideViewModel() {
        return new EditViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
