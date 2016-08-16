package com.servicesexperimentpoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStartService;
    private Button mBtnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStartService = (Button) findViewById(R.id.btn_start_service);
        mBtnStopService = (Button) findViewById(R.id.btn_stop_service);
        mBtnStartService.setOnClickListener(this);
        mBtnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                Intent startedIntent = new Intent(this, StartedService.class);
                startService(startedIntent);

                break;
            case R.id.btn_stop_service:
                Intent stopIntent = new Intent(this, StartedService.class);

                stopService(stopIntent);
                break;
        }
    }
}
