package com.natallialemiasheuskaya.homework9;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.natallialemiasheuskaya.homework1.databinding.ActivityHomeWork9Binding;
import com.natallialemiasheuskaya.homework3.*;
import com.natallialemiasheuskaya.homework3.CircularTransformation;
import com.squareup.picasso.Picasso;

/**
 * Created by natallialemiasheuskaya on 10.03.2018.
 */

public class User extends BaseObservable {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String sex;

    private final String imageBoy = "";
    private final String imageGirl = "";

    public User(String firstName, String lastName,int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }
    @Bindable
    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getImageBoy() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOzcOjujyhhZyamOw8latdaY4o93vDwnLsCowwUaKC0pqeHqKN0A";
    }

    public String getImageGirl() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGvR8QHEUxQM75xgk2mpRNy9L9c2rhfsxWVZ2vhurWzH_FodGlzw";
    }

    public boolean isMale(){

        if(sex.equals("male")){
            return true;
        }else return false;

    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImageUrl(ImageView imageView, String url){

        Picasso.with(imageView.getContext()).load(url).transform(new CircularTransformation()).into(imageView);

    }
}
