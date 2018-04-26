package com.natallialemiasheuskaya.domain.entity;

import java.util.List;

public class AccountsEntity {

    private String name;

   // private List<CoinEntity> coinList;

    public AccountsEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
