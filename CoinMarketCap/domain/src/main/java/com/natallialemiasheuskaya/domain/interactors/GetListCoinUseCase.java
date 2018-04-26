package com.natallialemiasheuskaya.domain.interactors;

import com.natallialemiasheuskaya.domain.entity.CoinsEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.CoinsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetListCoinUseCase extends BaseUseCase {

    private CoinsRepository coinRepository;

    @Inject
    public GetListCoinUseCase(PostExecutionThread postExecutionThread,
                          CoinsRepository coinRepository) {
        super(postExecutionThread);
        this.coinRepository = coinRepository;
    }

    public Flowable<List<CoinsEntity>> tickerList(int limit){

        return coinRepository.tickerList(limit)
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }
}
