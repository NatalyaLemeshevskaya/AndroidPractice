package com.natallialemiasheuskaya.dragon.injection;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natallialemiasheuskaya.data.net.RestApi;
import com.natallialemiasheuskaya.data.net.RestService;
import com.natallialemiasheuskaya.data.repository.ImageRepositoryImpl;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.ImageRepository;
import com.natallialemiasheuskaya.dragon.executor.UIThread;


import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {// помогает даггеру найти нужный тип

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides//-если кто то попросит обьект с методом context вызовет именно этот метод
    @Singleton
    public Context getContext(){
        return  context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        return new UIThread();
    }

    @Provides
    @Singleton
    public ImageRepository getImageRepository( RestService restService){
        return new ImageRepositoryImpl(restService);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson){
        return new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);

    }

    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder().create();
    }


}
