package com.natallialemiasheuskaya.presentation.sreens.homework8;


import android.os.Bundle;
import android.widget.TextView;

import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityHomeWork8Binding;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeWork8Activity extends BaseMVVMActivity<ActivityHomeWork8Binding,HW8ViewModel> {


    private TextView textViewNumber;
    private Observable<Long> observable;
    private Disposable disposable;


    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work8;
    }

    @Override
    public HW8ViewModel provideViewModel() {
        return new HW8ViewModel();
    }

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
    protected void onPause() {
        super.onPause();
        if(disposable != null){
            disposable.dispose();
        }

    }


}
