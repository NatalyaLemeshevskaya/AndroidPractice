package com.natallialemiasheuskaya.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.natallialemiasheuskaya.data.db.Converter;

import java.util.List;

@Entity(tableName = "Accounts")
public class Accounts {

    @PrimaryKey
    @NonNull
    private String name;

    @TypeConverters(Converter.class)
    public List<Coin> coinList;

    //private Double total;

//    public List<Coin> getCoinList() {
//        return coinList;
//    }
//
//    public void setCoinList(List<Coin> coinList) {
//        this.coinList = coinList;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
