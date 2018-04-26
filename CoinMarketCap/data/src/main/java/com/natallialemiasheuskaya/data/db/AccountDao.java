package com.natallialemiasheuskaya.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.natallialemiasheuskaya.data.entity.Accounts;
import com.natallialemiasheuskaya.data.entity.Coin;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface AccountDao {

    @Insert
    void insert(Accounts account);

    @Insert
    void insertCoin(List<Coin> coinList);

    @Query("SELECT * FROM Accounts")
    Flowable<List<Accounts>> getAll();

    @Query("SELECT * FROM Coin")
    Flowable<List<Coin>> getAllCoin();

//
//    @Query("DELETE FROM Accounts")
//    void deleteAll();

}
