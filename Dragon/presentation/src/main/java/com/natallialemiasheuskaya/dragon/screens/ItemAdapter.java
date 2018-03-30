package com.natallialemiasheuskaya.dragon.screens;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.natallialemiasheuskaya.domain.entity.ImageEntity;
import com.natallialemiasheuskaya.dragon.databinding.ItemImagesBinding;


import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<ImageEntity> list = new ArrayList<>();


    public void setImageList(List<ImageEntity> list) {

        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemImagesBinding binding = ItemImagesBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e("sds","adapterOnBind");
        Holder  myHolder = (Holder)holder;
        myHolder.itemImagesBinding.setImage(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ItemImagesBinding itemImagesBinding;

        Holder(View itemView) {
            super(itemView);

            itemImagesBinding = DataBindingUtil.bind(itemView);
        }
    }
}
