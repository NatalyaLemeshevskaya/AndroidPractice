package com.natallialemiasheuskaya.homework7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.natallialemiasheuskaya.homework1.R;

import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subscribers.TestSubscriber;

/**
 * Created by natallialemiasheuskaya on 01.03.2018.
 */

public class FragmentFirst extends Fragment {


    private PublishContract publishContract;
    private TextView textNumber;
    private Disposable disposable;


    public static FragmentFirst getInstance(){
        return new FragmentFirst();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.first_fragment,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textNumber = (TextView)view.findViewById(R.id.textNumber);
        subscribe();

    }

    @Override
    public void onResume() {
        super.onResume();



    }

    public void subscribe(){

        disposable = publishContract.getObservable()


                //трансформируе данные из Int в String
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })

                //начинается выполнение обсеребл
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //сюда приходят данные
                        textNumber.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //сюда прилетают ошибки
                    }
                });

    }

    @Override
    public void onPause() {
        super.onPause();
        if(disposable != null){
            disposable.dispose();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = getActivity();
        if(activity!=null){
            publishContract = (PublishContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }


}
