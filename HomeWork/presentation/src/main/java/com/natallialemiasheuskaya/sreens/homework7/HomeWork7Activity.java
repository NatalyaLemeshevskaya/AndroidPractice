package com.natallialemiasheuskaya.sreens.homework7;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.natallialemiasheuskaya.sreens.homework1.R;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HomeWork7Activity extends AppCompatActivity implements PublishContract{


    FragmentManager manager = getSupportFragmentManager();
 //   private boolean isOneFragment = true;

    private PublishSubject<Integer> publishSubject = PublishSubject.create();

    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work7);


        findViewById(R.id.buttonFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                publishSubject.onNext(count);
                count++;


            }
        });


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,FragmentFirst.getInstance());
        transaction.commit();
    }

    @Override
    public Observable<Integer> getObservable() {
        return publishSubject;
    }



}
