package com.natallialemiasheuskaya.sreens.homework1;

import android.databinding.ObservableField;
import com.natallialemiasheuskaya.base.BaseViewModel;


public class HW1ViewModel extends BaseViewModel {

    public ObservableField<String> text1 = new ObservableField<String>("egg");
    public ObservableField<String> text2 = new ObservableField<String>("chicken");
    public ObservableField<String> textButton = new ObservableField<String>("What was before?");


    public void mix(){

        String text1 =  this.text1.get();
        this.text1.set(text2.get());
        text2.set(text1);
    }



}
