package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyScheduledReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        Intent service = new Intent(context, ElServicio.class);
        context.startService(service);
    }
}
