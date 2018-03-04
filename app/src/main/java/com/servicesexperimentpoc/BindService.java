package com.servicesexperimentpoc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by aalishan on 4/11/16.
 */

public class BindService extends Service {
    private boolean isRandomNumberGenerator;
    private int randomNumber;
    private IBinder myBinder = new ServiceBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(BindService.this, "Service is started", Toast.LENGTH_SHORT).show();
        isRandomNumberGenerator = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    while (isRandomNumberGenerator) {
                        randomNumber = new Random().nextInt(40) + 1;;
                        Log.d("RandomNumber", "run: " + randomNumber);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(BindService.this, "Service is bind", Toast.LENGTH_SHORT).show();
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(BindService.this, "Service is un bind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(BindService.this, "Service is destroy", Toast.LENGTH_SHORT).show();
        stopRandomNumberGenerator();
    }

    public void stopRandomNumberGenerator() {
        isRandomNumberGenerator = false;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    class ServiceBinder extends Binder {
        public BindService getService() {
            return BindService.this;
        }
    }
}
