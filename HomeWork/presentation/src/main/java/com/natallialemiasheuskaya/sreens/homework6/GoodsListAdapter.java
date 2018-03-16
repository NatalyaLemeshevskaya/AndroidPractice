package com.natallialemiasheuskaya.sreens.homework6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.natallialemiasheuskaya.sreens.homework1.R;

import java.util.ArrayList;
import java.util.List;

public class GoodsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Goods> goodsList = new ArrayList<>();



    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList.clear();
        this.goodsList.addAll(goodsList);
        notifyDataSetChanged();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Holder  myHolder = (Holder)holder;
        final Goods goods = goodsList.get(position);

        myHolder.id.setText("Id"+goods.getId());
        myHolder.name.setText("Name: "+goods.getName());
        myHolder.description.setText("Description: "+goods.getDescription());
        myHolder.year.setText("Date: "+goods.getYear().toString());
        myHolder.price.setText("Price: "+goods.getPrice());



    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }


    static class Holder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        TextView description;
        TextView year;
        TextView price;
        ImageView imageGoods;


         Holder(View itemView) {
            super(itemView);
            Log.e("Adapter","create view holder");

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            year = itemView.findViewById(R.id.year);
            price = itemView.findViewById(R.id.price);


        }
    }
}
