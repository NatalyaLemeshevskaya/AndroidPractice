package com.natallialemiasheuskaya.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.natallialemiasheuskaya.data.entity.Coins;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CoinsDao {

    @Insert
    void insert(List<Coins> coinsList);

    @Query("SELECT * FROM Coins")
    Flowable<List<Coins>> getAll();

    @Query("DELETE FROM Coins")
    void deleteAll();

}
