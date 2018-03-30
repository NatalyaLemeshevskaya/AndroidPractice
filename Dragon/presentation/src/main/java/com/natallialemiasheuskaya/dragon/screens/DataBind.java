package com.natallialemiasheuskaya.dragon.screens;

import android.databinding.BindingAdapter;

import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.natallialemiasheuskaya.domain.entity.ImageEntity;

import java.util.List;

public class DataBind {

    @BindingAdapter({"src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).asGif().load(url).into(view);
    }

    @BindingAdapter({"android:entries"})

    public static void getAdapter(RecyclerView recyclerView, ObservableField<List<ImageEntity>> list){

        ItemAdapter adapter = (ItemAdapter) recyclerView.getAdapter();
        if(list.get()!= null){
        adapter.setImageList(list.get());
        }
    }
}
