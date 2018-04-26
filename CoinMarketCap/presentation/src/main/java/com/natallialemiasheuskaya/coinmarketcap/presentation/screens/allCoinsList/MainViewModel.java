package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allCoinsList;

import android.util.Log;

import com.natallialemiasheuskaya.coinmarketcap.app.App;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.domain.entity.CoinsEntity;
import com.natallialemiasheuskaya.domain.interactors.GetListCoinUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.natallialemiasheuskaya.data.entity.ErrorType.NO_INTERNET;
import static com.natallialemiasheuskaya.data.entity.ErrorType.SERVER_ERROR;
import static com.natallialemiasheuskaya.data.entity.ErrorType.SERVER_NOT_AVAILABLE;
import static com.natallialemiasheuskaya.data.entity.ErrorType.UNKNOWN;


public class MainViewModel extends BaseViewModel<MainRouter> {

    ItemAdapter itemAdapter = new ItemAdapter();

    public List<String> list;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    GetListCoinUseCase getListCoinUseCase;

    public MainViewModel() {
        super();


        getListCoinUseCase.tickerList(100).toObservable().subscribe(new Observer<List<CoinsEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<CoinsEntity> coinEntities) {
                itemAdapter.setCoinList(coinEntities);
            }

            @Override
            public void onError(Throwable e) {
               if(router!=null) {

                   if (e instanceof Error) {

//                        switch() {
//
//                            case NO_INTERNET: {
//
//                            }
//                            case SERVER_ERROR: {
//
//                            }
//                            case SERVER_NOT_AVAILABLE: {
//
//                            }
//                            case UNKNOWN: {
//
//                            }
//                        }
//
                    }
               }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
