package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio;

import com.natallialemiasheuskaya.coinmarketcap.app.App;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.domain.entity.AccountsEntity;
import com.natallialemiasheuskaya.domain.interactors.GetAllAccountUserCase;
import com.natallialemiasheuskaya.domain.interactors.SaveAccountUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PortfolioViewModel extends BaseViewModel<PortfolioRouter>{

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }


    PortfolioAdapter portfolioAdapter = new PortfolioAdapter();

    @Inject
    GetAllAccountUserCase getAllAccountUserCase;

    @Inject
    SaveAccountUseCase saveAccountUseCase;

    public PortfolioViewModel() {
        super();
        getAll();
    }


    public void getAll(){

                getAllAccountUserCase.getAllAccount()
                .toObservable()
                .subscribe(new Observer<List<AccountsEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<AccountsEntity> accountEntities) {
                        portfolioAdapter.setList(accountEntities);
                        portfolioAdapter.setListener(new PortfolioAdapter.OnAccountClickListener() {
                            @Override
                            public void onAccountClick(String name) {
                                if(router!= null){
                                    router.navigateToAccount(name);
                                }
                            }
                        });

                    }

                    @Override
                    public void onError(Throwable e) {

                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void saveAccount(String name){
        saveAccountUseCase.saveAccount(new AccountsEntity(name))
        .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });

    }

}

