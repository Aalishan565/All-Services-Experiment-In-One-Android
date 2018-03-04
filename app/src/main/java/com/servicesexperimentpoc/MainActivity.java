package com.servicesexperimentpoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStartedService;
    private Button mBtnIntentService;
    private Button mBtnBoundedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStartedService = (Button) findViewById(R.id.btn_started_service);
        mBtnIntentService = (Button) findViewById(R.id.btn_intent_service);
        mBtnBoundedService = (Button) findViewById(R.id.btn_bound_service);
        mBtnStartedService.setOnClickListener(this);
        mBtnIntentService.setOnClickListener(this);
        mBtnBoundedService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_started_service:
                Intent startedIntent = new Intent(this, StartedServiceActivity.class);
                startActivity(startedIntent);
                break;
            case R.id.btn_intent_service:
                Intent intentServiceIntent = new Intent(this, IntentServiceActivity.class);
                startActivity(intentServiceIntent);
                break;
            case R.id.btn_bound_service:
                Intent intentBoundIntent = new Intent(this, BindServiceActivity.class);
                startActivity(intentBoundIntent);
                break;
        }
    }
}
