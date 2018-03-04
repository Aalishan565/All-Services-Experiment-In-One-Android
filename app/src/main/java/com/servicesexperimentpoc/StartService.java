package com.servicesexperimentpoc;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by aalishan on 13/7/16.
 */
public class StartService extends Service {
    private Context ctx;

    final class MyThread implements Runnable {
        int serviceId;

        MyThread(int serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    @SuppressLint({"NewApi", "LocalSuppress"})
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                    Intent intent = new Intent("StartService");
                    intent.putExtra("data", "" + randomNum);
                    LocalBroadcastManager bm = LocalBroadcastManager.getInstance(ctx);
                    bm.sendBroadcast(intent);
                    wait(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            // stopSelf(serviceId);
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ctx = getApplicationContext();
        Toast.makeText(StartService.this, "Service is started", Toast.LENGTH_SHORT).show();
        Thread myThread = new Thread(new MyThread(startId));
        myThread.start();
        return START_NOT_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service is destroyed", Toast.LENGTH_SHORT).show();
    }
}
