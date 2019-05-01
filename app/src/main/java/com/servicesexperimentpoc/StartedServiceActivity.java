package com.servicesexperimentpoc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartedServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStartService;
    private Button mBtnStopService;
    private EditText mEtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);
        mBtnStartService = (Button) findViewById(R.id.btn_start_service);
        mBtnStopService = (Button) findViewById(R.id.btn_stop_service);
        mEtData = (EditText) findViewById(R.id.editText);
        mBtnStartService.setOnClickListener(this);
        mBtnStopService.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("StartService");
        LocalBroadcastManager bm = LocalBroadcastManager.getInstance(this);
        bm.registerReceiver(mBroadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager bm = LocalBroadcastManager.getInstance(this);
        bm.unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                Intent startedIntent = new Intent(this, StartService.class);
                startService(startedIntent);

                break;
            case R.id.btn_stop_service:
                Intent stopIntent = new Intent(this, StartService.class);
                stopService(stopIntent);
                break;
        }
    }

    // handler for received data from service
    private final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("StartService")) {
                final String param = intent.getStringExtra("data");
                mEtData.setText(param);
                // do something
            }
        }
    };
}
