package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allCoinsList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.natallialemiasheuskaya.coinmarketcap.R;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.coinmarketcap.databinding.ActivityMainBinding;
import com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio.PortfolioActivity;

public class MainActivity extends BaseMVVMActivity<ActivityMainBinding,MainViewModel,MainRouter> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel provideViewModel() {
        return new MainViewModel();
    }

    @Override
    public MainRouter provideRouter() {
        return new MainRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = binding.recycler;
        recyclerView.setAdapter(viewModel.itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);

        DrawerLayout drawerLayout = binding.drawer;

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = binding.nvView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case (R.id.nav_first_fragment) :{
                        Intent intent = new Intent(getApplicationContext(), PortfolioActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case (R.id.nav_second_fragment) :{
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer_view,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        return super.onOptionsItemSelected(item);
//    }
}
