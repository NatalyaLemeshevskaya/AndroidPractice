package com.natallialemiasheuskaya.sreens.homework5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class WifiService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service","onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Service","onStartCommand");
        return super.onStartCommand(intent, flags, startId);


    }


    public void disableWifi(Context context, Boolean bool) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if(bool)
            wifi.setWifiEnabled(false);
        else
            wifi.setWifiEnabled(true);
    }
}
