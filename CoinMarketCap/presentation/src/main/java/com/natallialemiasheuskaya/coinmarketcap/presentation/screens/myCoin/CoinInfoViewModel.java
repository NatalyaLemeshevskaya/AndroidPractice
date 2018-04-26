package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myCoin;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.util.Log;

import com.natallialemiasheuskaya.coinmarketcap.app.App;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;
import com.natallialemiasheuskaya.domain.interactors.GetListCoinUseCase;
import com.natallialemiasheuskaya.domain.interactors.SaveCoinUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CoinInfoViewModel  extends BaseViewModel<CoinInfoRouter>{

    public List<String> list = new ArrayList<>();
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableDouble price = new ObservableDouble(5);

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    GetListCoinUseCase getListCoinUseCase;

    @Inject
    public SaveCoinUseCase saveCoinUseCase;

    public CoinInfoViewModel() {
        super();

//        getListCoinUseCase.tickerList(100).toObservable().subscribe(new Observer<List<CoinsEntity>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                compositeDisposable.add(d);
//            }
//            @Override
//            public void onNext(List<CoinsEntity> coinEntities) {
//
//                for(CoinsEntity coinsEntity: coinEntities) {
//                    String names = coinsEntity.getName();
//                    list.add(names);
//                }
//                Log.e("onNext","onNext11111"+ list);
//
//            }
//            @Override
//            public void onError(Throwable e) {
//                Log.e("onNext","error"+e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
}

    public void onClick(){

        List<CoinEntity> coinEntities = new ArrayList<>();
        coinEntities.add(new CoinEntity(name.get(),price.get()));
        saveCoinUseCase.saveCoin(coinEntities);

        Log.e("onNext","save "+ coinEntities);
        if(router!=null){
            router.goBack(name.get());
            Log.e("onNext","name3 "+ name.get());

        }
    }
}
