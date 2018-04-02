package com.natallialemiasheuskaya.dragon.presentation.screens;

import android.databinding.ObservableField;
import android.text.Editable;
import android.util.Log;

import com.natallialemiasheuskaya.domain.entity.ImageEntity;
import com.natallialemiasheuskaya.domain.interactors.SearchUseCase;
import com.natallialemiasheuskaya.domain.interactors.TrendingUseCase;
import com.natallialemiasheuskaya.dragon.app.App;
import com.natallialemiasheuskaya.dragon.presentation.base.BaseViewModel;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;



public class MainViewModel extends BaseViewModel {


    public ItemAdapter itemAdapter = new ItemAdapter();


    public ObservableField<List<ImageEntity>> list = new ObservableField<>();

    @Inject
    public TrendingUseCase trendingUseCase;

    @Inject
    public SearchUseCase searchUseCase;


    @Override
    public void createInject() {

        App.getAppComponent().inject(this);
    }


    public  MainViewModel(){

        super();

        trendingUseCase.trendingImages().subscribe(new Observer<List<ImageEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);

            }

            @Override
            public void onNext(List<ImageEntity> imageEntities) {
                Log.e("sds","onNext " + imageEntities.size());
                itemAdapter.setImageList(imageEntities);
                Log.e("sds","onNext " + imageEntities.get(1).getUrl());

            }

            @Override
            public void onError(Throwable e) {
                Log.e("sds","error  " + e.toString());
            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void afterTextChanged(Editable search){


        searchUseCase.searchImage(search.toString()).subscribe(new Observer<List<ImageEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);

            }

            @Override
            public void onNext(List<ImageEntity> imageEntities) {
                itemAdapter.setImageList(imageEntities);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }




}
