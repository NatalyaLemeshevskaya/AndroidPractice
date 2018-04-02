package com.natallialemiasheuskaya.dragon.injection;



import com.natallialemiasheuskaya.dragon.presentation.screens.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class}) //компонент между даггером и классами вызывающими даггер
public interface AppComponent {

    void inject(MainViewModel mainViewModel);

}
