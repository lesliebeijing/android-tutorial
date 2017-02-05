package com.leslie.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by leslie.fang on 2017-02-05.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("leslie", "onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.d("leslie", "onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d("leslie", "onDestroy");
//        stopSelf();
        super.onDestroy();
    }
}
