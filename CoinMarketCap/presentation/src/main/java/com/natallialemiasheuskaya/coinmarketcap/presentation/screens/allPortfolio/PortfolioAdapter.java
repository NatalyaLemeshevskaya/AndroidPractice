package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.natallialemiasheuskaya.coinmarketcap.databinding.ItemPortfolioBinding;
import com.natallialemiasheuskaya.domain.entity.AccountsEntity;


import java.util.ArrayList;
import java.util.List;


public class PortfolioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    private List<AccountsEntity> list = new ArrayList<>();
    private OnAccountClickListener listener;

    public void setListener(OnAccountClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<AccountsEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPortfolioBinding binding = ItemPortfolioBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e("sds","adapterOnBind");
        Holder  myHolder = (Holder)holder;
        myHolder.itemPortfolioBinding.setItem(list.get(position));
        myHolder.itemPortfolioBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAccountClick(list.get(position).getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ItemPortfolioBinding itemPortfolioBinding;

        Holder(View itemView) {
            super(itemView);
            itemPortfolioBinding = DataBindingUtil.bind(itemView);
        }
    }

    public interface  OnAccountClickListener{
        void onAccountClick(String name);
    }

}
