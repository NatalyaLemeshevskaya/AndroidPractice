package com.natallialemiasheuskaya.presentation.sreens.homework5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityHomeWork5Binding;

public class HomeWork5Activity extends BaseMVVMActivity<ActivityHomeWork5Binding,HW5ViewModel> {


    ImageView imageWifi;
    IntentFilter intentFilter;
    Button wifiButton;


    @Override
    public int provideLayoutId() {
        return R.layout.activity_home_work5;
    }

    @Override
    public HW5ViewModel provideViewModel() {
        return new HW5ViewModel();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work5);

        imageWifi = (ImageView) findViewById(R.id.imageWifi);
        wifiButton = (Button) findViewById(R.id.wifiButton);



        wifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiService wifiService = new WifiService();
                WifiManager wifiManager = (WifiManager) HomeWork5Activity.this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                boolean bool =wifiManager.isWifiEnabled();
                wifiService.disableWifi(HomeWork5Activity.this,bool);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(myConnectiveReceiver,intentFilter);
        startService(new Intent(this,WifiService.class));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myConnectiveReceiver);
        stopService(new Intent(this,WifiService.class));


    }

    private BroadcastReceiver myConnectiveReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int WifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);

            switch (WifiState) {
                case WifiManager.WIFI_STATE_ENABLED: {
                    imageWifi.setImageResource(R.drawable.ic_signal_wifi_3_bar_black_24dp);
                }
                break;

                case WifiManager.WIFI_STATE_ENABLING: {
                    imageWifi.setImageResource(R.drawable.ic_signal_wifi_3_bar_black_24dp);
                }
                break;
                case WifiManager.WIFI_STATE_DISABLED: {
                    imageWifi.setImageResource(R.drawable.ic_signal_wifi_off_black_24dp);

                }
                break;

                case WifiManager.WIFI_STATE_DISABLING: {
                    imageWifi.setImageResource(R.drawable.ic_signal_wifi_off_black_24dp);

                }
                break;

            }

        }
    };


}
