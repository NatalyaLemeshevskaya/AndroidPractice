package com.natallialemiasheuskaya.dragon.presentation.screens;


import android.databinding.BindingAdapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;



public class DataBind {

    @BindingAdapter({"src"})

    public static void loadImage(ImageView view, String url) {

        Glide.with(view.getContext()).asGif().load(url).into(view);
    }


}
