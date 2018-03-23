package com.natallialemiasheuskaya.presentation.sreens.homework10;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;


import com.natallialemiasheuskaya.app.App;
import com.natallialemiasheuskaya.presentation.base.BaseViewModel;
import com.user.domain.entity.UserEntity;
import com.user.domain.interactors.GetUserByIdUseCase;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends BaseViewModel {

    @Override
    public void createInject() {

        App.getAppComponent().inject(this);

    }

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    public ObservableField<String> userName = new ObservableField<String>("");
    public ObservableField<String> profileUrl = new ObservableField<String>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible  = new ObservableBoolean(false);


    public UserViewModel() {

        super();

        progressVisible.set(true);

        getUserByIdUseCase
                .get("id")
                .subscribe(new Observer<UserEntity>(){

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("", "Subscribe");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {

                        Log.e("", "onNext");
                        userName.set(userEntity.getUserName());
                        profileUrl.set(userEntity.getProfileUrl());
                        age.set(userEntity.getAge());

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("", "onError");
                    }

                    @Override
                    public void onComplete() {

                        Log.e("", "onComplete");

                        progressVisible.set(false);

                    }
                });


    }



    @Override
    public void onResume() {


    }

    @Override
    public void onPause() {
        super.onPause();

    }


    //onDestroy =  когда нужно очистить данные
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
