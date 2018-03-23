package com.natallialemiasheuskaya.presentation.sreens.homework9;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.ImageView;

import com.natallialemiasheuskaya.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.presentation.sreens.homework3.CircularTransformation;
import com.squareup.picasso.Picasso;
import com.user.domain.entity.UserHW;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class User9ViewModel extends BaseViewModel {

    public ObservableField<String> firstName = new ObservableField<String>("");
    public ObservableField<String> lastName = new ObservableField<String>("");
    public ObservableInt age = new ObservableInt();
    public ObservableField<String> sex = new ObservableField<String>("");

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    public UserHW user;


    @Override
    public void createInject() {

    }

    @Override
    public void onStart() {
        Observable.create(new ObservableOnSubscribe<UserHW>(){
            @Override
            public void subscribe(ObservableEmitter<UserHW> emitter) throws Exception{
                Thread.sleep(5000);

                user = new UserHW("Иван","Петров",25,"male");

                emitter.onNext(user);
                emitter.onComplete();


            }
        })

                .subscribeOn(Schedulers.io())//куда прислать данные
                .observeOn(AndroidSchedulers.mainThread())// в каком потоке запустить(в новом, если кто не понял)
                .subscribe(new Observer<UserHW>(){

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("", "Subscribe");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserHW user) {

                        Log.e("", "onNext");
                        firstName.set(user.getFirstName());
                        lastName.set(user.getLastName());
                        age.set(user.getAge());
                        sex.set(user.getSex());

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("", "onError");
                    }

                    @Override
                    public void onComplete() {

                        Log.e("", "onComplete");


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

    public String getImageBoy() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOzcOjujyhhZyamOw8latdaY4o93vDwnLsCowwUaKC0pqeHqKN0A";
    }

    public String getImageGirl() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGvR8QHEUxQM75xgk2mpRNy9L9c2rhfsxWVZ2vhurWzH_FodGlzw";
    }

    public boolean isMale(){
        if(user!= null) {

            if (user.getSex().equals("male")) {
                return true;
            } else return false;
        }
        return false;
    }
    @BindingAdapter({"imageUrl"})
    public static void loadImageUrl(ImageView imageView, String url){

        Picasso.with(imageView.getContext()).load(url).transform(new CircularTransformation()).into(imageView);

    }



}
