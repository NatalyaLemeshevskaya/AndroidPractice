package com.natallialemiasheuskaya.coinmarketcap.injection;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natallialemiasheuskaya.coinmarketcap.BuildConfig;
import com.natallialemiasheuskaya.coinmarketcap.executor.UIThread;
import com.natallialemiasheuskaya.data.db.AppDatabase;
import com.natallialemiasheuskaya.data.db.AppDatabaseForCoins;
import com.natallialemiasheuskaya.data.net.RestApi;
import com.natallialemiasheuskaya.data.net.RestService;
import com.natallialemiasheuskaya.data.repository.AccountsRepositoryImpl;
import com.natallialemiasheuskaya.data.repository.CoinsRepositoryImpl;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.AccountsRepository;
import com.natallialemiasheuskaya.domain.repository.CoinsRepository;

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
    public CoinsRepository getCoinRepository(Context context, RestService restService, AppDatabaseForCoins appDatabaseForCoins){
        return new CoinsRepositoryImpl(context,restService,appDatabaseForCoins);
    }

    @Provides
    @Singleton
    public AccountsRepository getAccountRepository(Context context, AppDatabase dataBase){
        return new AccountsRepositoryImpl(context,dataBase);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);

    }

    @Provides
    @Singleton
    public AppDatabase getDataBase(Context context){

        AppDatabase appDatBase = Room.databaseBuilder(context,
                AppDatabase.class,"databaseAccount")
                .fallbackToDestructiveMigration()
                .build();

        return appDatBase;

    }

    @Provides
    @Singleton
    public AppDatabaseForCoins getDataBaseForCoins(Context context){

        AppDatabaseForCoins appDatabaseForCoins = Room.databaseBuilder(context,
                AppDatabaseForCoins.class,"databaseCoins")
                .fallbackToDestructiveMigration()
                .build();

        return appDatabaseForCoins;

    }



    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder().create();
    }



}
