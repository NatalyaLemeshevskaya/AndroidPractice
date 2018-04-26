package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.myPortfolio;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.natallialemiasheuskaya.coinmarketcap.databinding.ItemMyCoinsBinding;
import com.natallialemiasheuskaya.domain.entity.CoinEntity;

import java.util.ArrayList;
import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    private List<CoinEntity> list = new ArrayList<>();
   // private PortfolioAdapter.OnAccountClickListener listener;

//    public void setListener(PortfolioAdapter.OnAccountClickListener listener) {
//        this.listener = listener;
//    }

    public void setList(List<CoinEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMyCoinsBinding binding = ItemMyCoinsBinding.inflate(inflater, parent, false);
        return new CoinsAdapter.Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CoinsAdapter.Holder myHolder = (CoinsAdapter.Holder)holder;
        myHolder.itemMyCoinsBinding.setItem(list.get(position));
//        myHolder.itemPortfolioBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onAccountClick(list.get(position).getName());
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ItemMyCoinsBinding itemMyCoinsBinding;

        Holder(View itemView) {
            super(itemView);
            itemMyCoinsBinding = DataBindingUtil.bind(itemView);
        }
    }

//    public interface  OnAccountClickListener{
//        void onAccountClick(String name);
//    }

}
