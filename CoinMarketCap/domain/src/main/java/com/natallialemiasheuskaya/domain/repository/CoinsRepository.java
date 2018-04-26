package com.natallialemiasheuskaya.domain.repository;

import com.natallialemiasheuskaya.domain.entity.CoinsEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface CoinsRepository {

    Flowable<List<CoinsEntity>> tickerList(int limit);
    Flowable<List<CoinsEntity>> tickerDetail(String id, String convert);
}
