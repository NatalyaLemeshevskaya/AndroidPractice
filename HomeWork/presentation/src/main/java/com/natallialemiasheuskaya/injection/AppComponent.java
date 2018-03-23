package com.natallialemiasheuskaya.injection;



import com.natallialemiasheuskaya.presentation.sreens.homework10.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class}) //компонент между даггером и классами вызывающими даггер
public interface AppComponent {


    void inject(UserViewModel userViewModel);

}
