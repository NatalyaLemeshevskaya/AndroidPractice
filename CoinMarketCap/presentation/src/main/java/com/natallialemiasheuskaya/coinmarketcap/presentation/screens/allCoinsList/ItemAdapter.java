package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allCoinsList;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.natallialemiasheuskaya.coinmarketcap.databinding.ItemCoinBinding;
import com.natallialemiasheuskaya.domain.entity.CoinsEntity;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<CoinsEntity> list = new ArrayList<>();

    public void setCoinList(List<CoinsEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCoinBinding binding = ItemCoinBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e("sds","adapterOnBind");
        Holder  myHolder = (Holder)holder;
        myHolder.itemCoinBinding.setItem(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ItemCoinBinding itemCoinBinding;

        Holder(View itemView) {
            super(itemView);

            itemCoinBinding = DataBindingUtil.bind(itemView);
        }
    }

}
