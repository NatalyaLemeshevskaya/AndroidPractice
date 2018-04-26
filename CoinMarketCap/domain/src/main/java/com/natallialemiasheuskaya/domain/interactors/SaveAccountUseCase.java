package com.natallialemiasheuskaya.domain.interactors;

import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveAccountUseCase extends BaseUseCase {


    private AccountsRepository accountRepository;


    @Inject
    public SaveAccountUseCase(PostExecutionThread postExecutionThread, AccountsRepository accountRepository) {
        super(postExecutionThread);
        this.accountRepository = accountRepository;
    }


    public Completable saveAccount(AccountsEntity accountEntity){
       return accountRepository.insert(accountEntity)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
