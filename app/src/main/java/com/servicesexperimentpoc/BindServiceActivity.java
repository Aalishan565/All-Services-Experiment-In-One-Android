package com.servicesexperimentpoc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BindServiceActivity extends AppCompatActivity {
    private TextView mTvRandomNumber;
    private Button mBtnStartService;
    private Button mBtnStopService;
    private Button mBtnBindService;
    private Button mBtnUnBindService;
    private Button mBtnRandomNumber;

    private ServiceConnection serviceConnection;
    private BindService bindServiceobj;
    private boolean isServiceBound;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service);

        mTvRandomNumber = (TextView) findViewById(R.id.tv_numbers);
        mBtnStartService = (Button) findViewById(R.id.btn_start_service);
        mBtnStopService = (Button) findViewById(R.id.btn_stop_service);
        mBtnBindService = (Button) findViewById(R.id.btn_bound_service);
        mBtnUnBindService = (Button) findViewById(R.id.btn_unbind_service);
        mBtnRandomNumber = (Button) findViewById(R.id.btn_set_random_number);

        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(BindServiceActivity.this, BindService.class);
                startService(intent);


            }
        });
        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(BindServiceActivity.this, BindService.class);
                stopService(intent);


            }
        });
        mBtnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceConnection == null) {
                    serviceConnection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            isServiceBound = true;
                            BindService.ServiceBinder myBinder = (BindService.ServiceBinder) service;
                            bindServiceobj = myBinder.getService();
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                            isServiceBound = false;

                        }
                    };

                }
                intent = new Intent(BindServiceActivity.this, BindService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);

            }
        });
        mBtnUnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isServiceBound) {
                    isServiceBound = false;
                    unbindService(serviceConnection);
                }


            }
        });
        mBtnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isServiceBound) {
                    mTvRandomNumber.setText("" + bindServiceobj.getRandomNumber());

                } else {
                    mTvRandomNumber.setText("Service is not bound..");
                }


            }
        });

    }
}
