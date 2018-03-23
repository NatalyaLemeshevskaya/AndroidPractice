package com.natallialemiasheuskaya.injection;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natallialemiasheuskaya.executor.UIThread;
import com.user.data.net.RestApi;
import com.user.data.net.RestService;
import com.user.data.repository.UserRepositoryImpl;
import com.user.domain.executor.PostExecutionThread;
import com.user.domain.repository.UserRepository;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    @Named("repository1")
    public UserRepository getUserRepository(Context context, RestService restService){
        return new UserRepositoryImpl(context,restService);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson){
        //return new Retrofit.Builder().addCallAdapterFactory()

return null;

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

//    @Provides
//    @Singleton
//    @Named("repository2")
//    public UserRepository getUserRepository2(){
//        return new UserRepositoryImpl();
//    }




    //    =
//    @Binds
//    public abstract PostExecutionThread getUiThread(UIThread uiThread);
//    весь класс тоже делает abstract
//
}
