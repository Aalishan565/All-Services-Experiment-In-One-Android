package com.servicesexperimentpoc;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentServiceActivity extends AppCompatActivity {
    private Button mBtnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        mBtnStartIntentService = (Button) findViewById(R.id.btn_start_intent_service);
        mBtnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startedIntent = new Intent(IntentServiceActivity.this, IntentServiceClass.class);
                for (int i=0;i<10;i++){
                    startService(startedIntent);
                }

            }
        });
    }
}
