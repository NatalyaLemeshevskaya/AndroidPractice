package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio;

import android.app.Activity;
import android.content.Intent;

import com.natallialemiasheuskaya.coinmarketcap.presentation.base.Router;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio.CoinsActivity;

public class PortfolioRouter extends Router {

    public PortfolioRouter(Activity activity) {
        super(activity);
    }

    public void navigateToAccount(String name){
        Intent intent = new Intent(getActivity(),CoinsActivity.class);
        intent.putExtra("NAME",name);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);

    }


}
