package com.natallialemiasheuskaya.dragon.presentation.screens;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.natallialemiasheuskaya.dragon.R;
import com.natallialemiasheuskaya.dragon.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.dragon.databinding.ActivityMainBinding;

public class MainActivity extends BaseMVVMActivity<ActivityMainBinding,MainViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setAdapter(viewModel.itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


    }
}
