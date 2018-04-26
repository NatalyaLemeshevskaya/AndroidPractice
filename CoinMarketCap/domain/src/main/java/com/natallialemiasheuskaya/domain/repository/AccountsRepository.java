package com.natallialemiasheuskaya.domain.repository;

import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface AccountsRepository {

    Flowable<List<AccountsEntity>> getAllAccount();
    Flowable<List<CoinEntity>> getAllCoin();
    Completable insert(AccountsEntity accountEntity);
    Completable insertCoins(List<CoinEntity> coinEntities);

}
