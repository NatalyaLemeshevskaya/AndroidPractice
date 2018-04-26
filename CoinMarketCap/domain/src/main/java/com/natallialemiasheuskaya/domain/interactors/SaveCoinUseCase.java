package com.natallialemiasheuskaya.domain.interactors;

import com.natallialemiasheuskaya.domain.entity.CoinEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveCoinUseCase extends BaseUseCase {

    private AccountsRepository accountRepository;

    @Inject
    public SaveCoinUseCase(PostExecutionThread postExecutionThread, AccountsRepository accountRepository) {
        super(postExecutionThread);
        this.accountRepository = accountRepository;
    }

    public Completable saveCoin(List<CoinEntity> coinEntities){
        return accountRepository.insertCoins(coinEntities)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
