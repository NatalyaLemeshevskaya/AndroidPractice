package com.natallialemiasheuskaya.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.natallialemiasheuskaya.data.entity.Accounts;
import com.natallialemiasheuskaya.data.entity.Coin;

@Database(entities = {Accounts.class,Coin.class},version = 2)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract AccountDao accountDao();
}
