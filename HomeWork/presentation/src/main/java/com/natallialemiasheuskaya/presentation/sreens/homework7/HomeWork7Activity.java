package com.natallialemiasheuskaya.presentation.sreens.homework7;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityHomeWork7Binding;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HomeWork7Activity extends BaseMVVMActivity<ActivityHomeWork7Binding,HW7ViewModel> implements PublishContract{


    FragmentManager manager = getSupportFragmentManager();
 //   private boolean isOneFragment = true;

    private PublishSubject<Integer> publishSubject = PublishSubject.create();

    private int count = 0;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work7;
    }

    @Override
    public HW7ViewModel provideViewModel() {
        return new HW7ViewModel();
    }

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
