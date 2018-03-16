package com.natallialemiasheuskaya.sreens.homework10;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;


import com.natallialemiasheuskaya.base.BaseViewModel;
import com.user.domain.entity.UserEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends BaseViewModel {

    public ObservableField<String> userName = new ObservableField<String>("");
    public ObservableField<String> profileUrl = new ObservableField<String>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible  = new ObservableBoolean(false);

    public CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    public void onResume() {

        progressVisible.set(true);

        Observable.create(new ObservableOnSubscribe<UserEntity>(){
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception{
                Thread.sleep(5000);

                UserEntity entity = new UserEntity("super username", 20, "");

                emitter.onNext(entity);
                emitter.onComplete();


            }
        })

                .subscribeOn(Schedulers.io())//куда прислать данные
                .observeOn(AndroidSchedulers.mainThread())// в каком потоке запустить(в новом, если кто не понял)
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
    public void onPause() {
        super.onPause();
        if(compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
