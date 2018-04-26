package com.natallialemiasheuskaya.domain.interactors;

import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetAllAccountUserCase extends BaseUseCase {


    private AccountsRepository accountRepository;

    @Inject
    public GetAllAccountUserCase(PostExecutionThread postExecutionThread,
                                 AccountsRepository accountRepository) {
        super(postExecutionThread);
        this.accountRepository = accountRepository;
    }

    public Flowable<List<AccountsEntity>> getAllAccount(){

        return accountRepository.getAllAccount()
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }
}
