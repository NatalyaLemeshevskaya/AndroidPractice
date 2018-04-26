package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myCoin;

import android.app.Activity;
import android.content.Intent;

import com.natallialemiasheuskaya.coinmarketcap.presentation.base.Router;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio.CoinsActivity;

public class CoinInfoRouter extends Router {

    public CoinInfoRouter(Activity activity) {
        super(activity);
    }

    public void goBack(String name){
        Intent intent = new Intent(getActivity(),CoinsActivity.class);
        intent.putExtra("NAME_COIN",name);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       // intent.putExtra("PRICE",price);
        getActivity().startActivity(intent);
    }
}
