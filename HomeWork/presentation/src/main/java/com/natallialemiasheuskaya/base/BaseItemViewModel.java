package com.natallialemiasheuskaya.base;

public abstract class BaseItemViewModel<Model> extends BaseViewModel {

    public abstract void setItem(Model item, int position);

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }
}















