package com.natallialemiasheuskaya.sreens.homework6;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


import com.natallialemiasheuskaya.sreens.homework1.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class HomeWork6Activity extends Activity {

    private RecyclerView recyclerView;
    private GoodsListAdapter goodsListAdapter;
    private DownloaderTask downloaderTask;
    private Button buttonLoad;
    private ProgressBar progressBar;
    private EditText textForFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work6);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        goodsListAdapter = new GoodsListAdapter();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(goodsListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        buttonLoad = (Button) findViewById(R.id.buttonLoad);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloaderTask = new DownloaderTask();
                downloaderTask.execute();
            }
        });

        textForFind = (EditText) findViewById(R.id.textForFind);
        textForFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                findByName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    class DownloaderTask extends AsyncTask<String,Void,Root> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Root doInBackground(String... strings) {

            try {
                DownLoader.loader(HomeWork6Activity.this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return JSONParser.parse(HomeWork6Activity.this);
        }

        @Override
        protected void onPostExecute(Root root) {
            super.onPostExecute(root);
            if(root.getGoods() != null)
            goodsListAdapter.setGoodsList(root.getGoods());

            progressBar.setVisibility(View.INVISIBLE);
            textForFind.setVisibility(View.VISIBLE);
        }
    }

    private void findByName(String name) {

            List<Goods> goods = new ArrayList<>();
            for (Goods g : goodsListAdapter.getGoodsList()) {
                if (g.getName().toLowerCase().contains(name.toLowerCase())) {
                    goods.add(g);
                }
            }
            goodsListAdapter.setGoodsList(goods);

    }
}
