package com.natallialemiasheuskaya.injection;


import com.natallialemiasheuskaya.presentation.sreens.homework9.User9ViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class}) //компонент между даггером и классами вызывающими даггер
public interface AppComponent {

    void inject(User9ViewModel usersViewModel);

}
