package com.servicesexperimentpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoundedServiceActivity extends AppCompatActivity {
private Button mBtnStartBoundedService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service);
        mBtnStartBoundedService= (Button) findViewById(R.id.btn_start_bound_service);
        mBtnStartBoundedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
