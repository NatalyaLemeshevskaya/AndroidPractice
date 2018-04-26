package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myCoin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.natallialemiasheuskaya.coinmarketcap.R;
import com.natallialemiasheuskaya.coinmarketcap.databinding.ActivityCoinInfoBinding;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseMVVMActivity;


import java.util.List;

public class CoinInfoActivity extends BaseMVVMActivity<ActivityCoinInfoBinding,CoinInfoViewModel,CoinInfoRouter> {


    List<String> list;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_coin_info;
    }

    @Override
    public CoinInfoViewModel provideViewModel() {
        return new CoinInfoViewModel();
    }

    @Override
    public CoinInfoRouter provideRouter() {
        return new CoinInfoRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       AutoCompleteTextView autoCompleteTextView = binding.textAuto;
       TextView textView = binding.detailsTextView;

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.simple_dropdown_item_1line_mod,viewModel.list);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.name.set(autoCompleteTextView.getText().toString());
            }
        });
   }

}
