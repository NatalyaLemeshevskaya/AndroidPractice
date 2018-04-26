package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio;

import android.app.Activity;
import android.content.Intent;

import com.natallialemiasheuskaya.coinmarketcap.presentation.base.Router;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myCoin.CoinInfoActivity;

public class CoinsRouter extends Router {
    public CoinsRouter(Activity activity) {
        super(activity);
    }
    public void navigateToCoinInfo(){
        Intent intent = new Intent(getActivity(),CoinInfoActivity.class);
       // intent.putExtra("NAME",name);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);

    }


}
