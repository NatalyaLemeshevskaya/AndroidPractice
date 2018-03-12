package com.natallialemiasheuskaya.homework9;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.natallialemiasheuskaya.homework3.CircularTransformation;
import com.squareup.picasso.Picasso;

public class UserViewModel extends BaseObservable {

    private User user;

    private final String imageBoy = "";
    private final String imageGirl = "";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    @Bindable
    public String getFirstName() {

        if (user != null) {
            return user.getFirstName();
        }
        return null;

    }
    @Bindable
    public String getLastName() {
        if (user != null) {
            return user.getLastName();
        }
        return null;
    }
    @Bindable
    public String getSex() {
        if (user != null) {
            return user.getSex();
        }
        return null;
    }

    @Bindable
    public String getAge() {
        if (user != null) {
            return String.valueOf(user.getAge());
        }
        return null;
    }


    public String getImageBoy() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOzcOjujyhhZyamOw8latdaY4o93vDwnLsCowwUaKC0pqeHqKN0A";
    }

    public String getImageGirl() {
        return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGvR8QHEUxQM75xgk2mpRNy9L9c2rhfsxWVZ2vhurWzH_FodGlzw";
    }

    public boolean isMale(){
        if(user!= null) {

            if (user.getSex().equals("male")) {
                return true;
            } else return false;
        }
        return false;
    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImageUrl(ImageView imageView, String url){

        Picasso.with(imageView.getContext()).load(url).transform(new CircularTransformation()).into(imageView);

    }

}
