package com.natallialemiasheuskaya.coinmarketcap.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.natallialemiasheuskaya.coinmarketcap.injection.AppComponent;
import com.natallialemiasheuskaya.coinmarketcap.injection.AppModule;
import com.natallialemiasheuskaya.coinmarketcap.injection.DaggerAppComponent;
import io.fabric.sdk.android.Fabric;


public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();



    }

}
