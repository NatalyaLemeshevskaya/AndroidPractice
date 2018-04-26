package com.natallialemiasheuskaya.coinmarketcap.injection;

import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allCoinsList.MainViewModel;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio.PortfolioViewModel;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myCoin.CoinInfoViewModel;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio.CoinsViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class}) //компонент между даггером и классами вызывающими даггер
public interface AppComponent {

    void inject(MainViewModel mainViewModel);
    void inject(PortfolioViewModel portfolioViewModel);
    void inject(CoinsViewModel coinsViewModel);
    void inject(CoinInfoViewModel coinInfoViewModel);


}
