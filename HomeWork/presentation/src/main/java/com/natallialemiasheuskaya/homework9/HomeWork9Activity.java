package com.natallialemiasheuskaya.homework9;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.natallialemiasheuskaya.homework1.R;
import com.natallialemiasheuskaya.homework1.databinding.ActivityHomeWork9Binding;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HomeWork9Activity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHomeWork9Binding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_home_work9);

        Observable<User> observable = Observable.just(new User("Иван","Петров",25,"male"));
        disposable = observable.delay(3, TimeUnit.SECONDS).subscribe(user -> binding.setUser(user));
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(disposable != null){
            disposable.dispose();
        }
    }
}
