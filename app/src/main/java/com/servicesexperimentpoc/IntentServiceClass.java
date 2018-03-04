package com.servicesexperimentpoc;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by aalishan on 4/11/16.
 */

public class IntentServiceClass extends IntentService {
    /**
     * Creates an IntentServiceClass.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServiceClass(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {



    }
}
