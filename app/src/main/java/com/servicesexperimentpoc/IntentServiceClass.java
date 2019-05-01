package com.servicesexperimentpoc;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by aalishan on 4/11/16.
 */

public class IntentServiceClass extends IntentService {

    public IntentServiceClass() {
        super("Intent service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Intent service", "onHandleIntent");
    }
}
