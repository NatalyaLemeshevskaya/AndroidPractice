package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio;

import com.natallialemiasheuskaya.coinmarketcap.app.App;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;
import com.natallialemiasheuskaya.domain.interactors.GetAllCoinUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CoinsViewModel extends BaseViewModel<CoinsRouter> {
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public String nameAccount;

    public String nameCoin;

    public Double price = new Double(5);

    public CoinsAdapter coinsAdapter;

    @Inject
    public GetAllCoinUseCase getAllCoinUseCase;

    public CoinsViewModel() {
        super();

        getAllCoinUseCase.getAllCoin()
                .toObservable()
                .subscribe(new Observer<List<CoinEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<CoinEntity> coinEntities) {
                        coinsAdapter.setList(coinEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void onClickButton(){

        if(router!=null){
            router.navigateToCoinInfo();
        }
    }



}
