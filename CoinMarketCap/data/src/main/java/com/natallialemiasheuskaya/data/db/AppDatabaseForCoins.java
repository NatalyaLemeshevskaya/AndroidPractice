package com.natallialemiasheuskaya.data.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.natallialemiasheuskaya.data.entity.Coins;

@Database(entities = {Coins.class},version = 2)
public abstract class AppDatabaseForCoins extends RoomDatabase {

    public abstract CoinsDao coinsDao();
}
