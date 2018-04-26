package com.natallialemiasheuskaya.domain.interactors;

import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetAllCoinUseCase extends BaseUseCase {

    private AccountsRepository accountRepository;

    @Inject
    public GetAllCoinUseCase(PostExecutionThread postExecutionThread,
                                 AccountsRepository accountRepository) {
        super(postExecutionThread);
        this.accountRepository = accountRepository;
    }
    public Flowable<List<CoinEntity>> getAllCoin(){

        return accountRepository.getAllCoin()
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }
}
