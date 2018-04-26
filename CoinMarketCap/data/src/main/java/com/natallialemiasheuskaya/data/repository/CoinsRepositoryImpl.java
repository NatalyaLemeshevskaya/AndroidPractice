package com.natallialemiasheuskaya.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.natallialemiasheuskaya.data.db.AppDatabaseForCoins;
import com.natallialemiasheuskaya.data.db.CoinsDao;
import com.natallialemiasheuskaya.data.entity.Coins;
import com.natallialemiasheuskaya.data.net.RestService;
import com.natallialemiasheuskaya.domain.entity.CoinsEntity;
import com.natallialemiasheuskaya.domain.repository.CoinsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class CoinsRepositoryImpl implements CoinsRepository {

    private Context context;
    private RestService restService;
    private CoinsDao coinsDao;


    @Inject
    public CoinsRepositoryImpl(Context context, RestService restService, AppDatabaseForCoins appDatabaseForCoins) {
        this.restService = restService;
        this.context = context;
        this.coinsDao = appDatabaseForCoins.coinsDao();
    }


    @Override
    public Flowable<List<CoinsEntity>> tickerList(int limit) {

        Flowable<List<Coins>> coins;

        if(isNetworkAvailable()) {
            coins =restService
                    .tickerList(limit)
                    .doOnNext(new Consumer<List<Coins>>() {
                        @Override
                        public void accept(List<Coins> coin) throws Exception {
                            coinsDao.deleteAll();
                            coinsDao.insert(coin);
                        }
                    });
        }else
            coins = coinsDao.getAll().take(1);


        return coins
                .map(new Function<List<Coins>, List<CoinsEntity>>() {
                    @Override
                    public List<CoinsEntity> apply(List<Coins> coins) throws Exception {
                        List<CoinsEntity> list = new ArrayList<>();
                        for(Coins coin:coins){
                            list.add(new CoinsEntity
                                    (coin.getId(),coin.getName(),coin.getSymbol(),coin.getRank(),coin.getPriceUsd()));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Flowable<List<CoinsEntity>> tickerDetail(String id, String convert) {
        return restService.tickerDetail(id,convert)
                .map(new Function<List<Coins>, List<CoinsEntity>>() {
                    @Override
                    public List<CoinsEntity> apply(List<Coins> coins) throws Exception {
                        List<CoinsEntity> list = new ArrayList<>();
                        for(Coins coin:coins){
                            list.add(new CoinsEntity
                                    (coin.getId(),coin.getName(),coin.getSymbol(),coin.getRank(),coin.getPriceUsd()));
                        }
                        return list;
                    }
                });
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
