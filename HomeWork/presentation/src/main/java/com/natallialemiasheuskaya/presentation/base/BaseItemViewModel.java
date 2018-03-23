package com.natallialemiasheuskaya.presentation.base;

/**
 * Created by natallialemiasheuskaya on 23.03.2018.
 */

public abstract class BaseItemViewModel<Model> extends BaseViewModel {

    public abstract void setItem(Model item, int position);

    public void init() {
    }

    public void release() {
    }

}
