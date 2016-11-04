package com.servicesexperimentpoc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by aalishan on 13/7/16.
 */
public class StartedService extends Service {
    final class MyThread implements Runnable {
        int serviceId;

        MyThread(int serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait(20000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();                                                                                                                                                                                                                                                                                    Trace();
                }
            }
            stopSelf(serviceId);
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(StartedService.this, "Service is started", Toast.LENGTH_SHORT).show();
        Thread myThread = new Thread(new MyThread(startId));
        myThread.start();
        return START_STICKY;
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
