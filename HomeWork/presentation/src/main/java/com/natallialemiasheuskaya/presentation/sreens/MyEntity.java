package com.natallialemiasheuskaya.presentation.sreens;

import android.database.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by natallialemiasheuskaya on 05.03.2018.
 */

public class MyEntity {


     public ObservableField<String> text = new ObservableField<String>("");
     public ObservableField<String> textButton = new ObservableField<String>("");
     public ObservableBoolean buttonVisible  = new ObservableBoolean(true);

    public MyEntity(String text, String textButton) {
        this.text.set(text);
        this.textButton.set(textButton);
    }


    public void buttonClick(View view){
        Log.e("MyEntity","Msg");
        buttonVisible.set(false);

    }
}
