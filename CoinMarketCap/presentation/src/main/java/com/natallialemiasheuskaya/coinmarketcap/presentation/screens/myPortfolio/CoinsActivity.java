package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.natallialemiasheuskaya.coinmarketcap.R;
import com.natallialemiasheuskaya.coinmarketcap.databinding.ActivityCoinsBinding;

import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseMVVMActivity;

public class CoinsActivity extends BaseMVVMActivity<ActivityCoinsBinding,CoinsViewModel,CoinsRouter> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_coins;
    }

    @Override
    public CoinsViewModel provideViewModel() {
        CoinsViewModel  coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel.class);
        coinsViewModel.nameAccount = getIntent().getStringExtra("NAME");
        coinsViewModel.nameCoin = getIntent().getStringExtra("NAME_COIN");
        return coinsViewModel;
    }

    @Override
    public CoinsRouter provideRouter() {
        return new CoinsRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        RecyclerView recyclerView = binding.recyclerCoins;
//        recyclerView.setAdapter(viewModel.coinsAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);


    }
}
