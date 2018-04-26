package com.natallialemiasheuskaya.data.repository;

import android.content.Context;

import com.natallialemiasheuskaya.data.db.AppDatabase;
import com.natallialemiasheuskaya.data.db.AccountDao;
import com.natallialemiasheuskaya.data.entity.Accounts;
import com.natallialemiasheuskaya.data.entity.Coin;
import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;
import com.natallialemiasheuskaya.domain.entity.CoinsEntity;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class AccountsRepositoryImpl implements AccountsRepository {

    private Context context;
    private AccountDao userDao;

    @Inject
    public AccountsRepositoryImpl(Context context, AppDatabase database) {
        this.context = context;
        this.userDao = database.accountDao();
    }


    @Override
    public Flowable<List<AccountsEntity>> getAllAccount() {

        Flowable<List<Accounts>> accounts;
        accounts = userDao.getAll();
        return accounts.map(new Function<List<Accounts>, List<AccountsEntity>>() {
            @Override
            public List<AccountsEntity> apply(List<Accounts> accounts) throws Exception {
                List<AccountsEntity> list = new ArrayList<>();
                for(Accounts account: accounts){
                    list.add(new AccountsEntity(account.getName()));
                }
                return list;
            }
        });

    }

    @Override
    public Flowable<List<CoinEntity>> getAllCoin() {
        final Flowable<List<Coin>> coins;
        coins = userDao.getAllCoin();
        return  coins.map(new Function<List<Coin>, List<CoinEntity>>() {
            @Override
            public List<CoinEntity> apply(List<Coin> coinList) throws Exception {
                List<CoinEntity> list = new ArrayList<>();
                for(Coin coin: coinList){
                    list.add(new CoinEntity(coin.getName(),coin.getCount()));
                }
                return list;
            }
        });
    }

    @Override
    public Completable insert(final AccountsEntity accountEntity) {

        return Completable
                .create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {

                Accounts account = new Accounts();
                account.setName(accountEntity.getName());

                userDao.insert(account);
                emitter.onComplete();

            }
        });
    }

    @Override
    public Completable insertCoins(final List<CoinEntity> coinEntities) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {

                List<Coin> coins = new ArrayList<>();
                for(CoinEntity coinEntity: coinEntities) {
                    coins.add(new Coin(coinEntity.getName(),coinEntity.getCount()));
                }

                userDao.insertCoin(coins);
                emitter.onComplete();
            }
        });
    }

}
