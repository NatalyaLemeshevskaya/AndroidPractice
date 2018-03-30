package com.natallialemiasheuskaya.dragon.app;

import android.app.Application;

import com.natallialemiasheuskaya.dragon.injection.AppComponent;
import com.natallialemiasheuskaya.dragon.injection.AppModule;
import com.natallialemiasheuskaya.dragon.injection.DaggerAppComponent;


//MultyDeks - если супер большое приложение
public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();



    }

}
