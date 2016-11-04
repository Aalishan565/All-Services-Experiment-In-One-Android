package com.servicesexperimentpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentServiceActivity extends AppCompatActivity {
    private Button mBtnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        mBtnStartIntentService= (Button) findViewById(R.id.btn_start_intent_service);
        mBtnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
