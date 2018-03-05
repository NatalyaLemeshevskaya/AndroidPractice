package com.natallialemiasheuskaya.homework8;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.natallialemiasheuskaya.homework1.R;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HomeWork8Activity extends AppCompatActivity {


    private TextView textViewNumber;
    private Observable<Long> observable;
    private Disposable disposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work8);

        textViewNumber = (TextView) findViewById(R.id.textViewNumber);
        observable = Observable
                .interval(1,TimeUnit.SECONDS,Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        disposable = observable
                .filter(aLong -> aLong%2 ==0 )
                .map(aLong -> String.valueOf(aLong))
                .subscribe(s -> textViewNumber.setText(s));



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(disposable != null){
            disposable.dispose();
        }

    }
}
