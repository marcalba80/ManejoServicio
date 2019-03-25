package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyScheduledReceiver extends BroadcastReceiver {
    Intent service;
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)){
            int state = intent.getIntExtra("state", -1);
            switch (state){
                case 1:
                    Toast.makeText(context, "Intent Recibido - Evento del sistema ON", Toast.LENGTH_LONG).show();
                    service = new Intent(context, ElServicio.class);
                    service.putExtra("opcion", context.getResources().getString(R.string.song));
                    context.startService(service);
                    break;
                case 0:
                    Toast.makeText(context, "Intent Recibido - Evento del sistema OFF", Toast.LENGTH_LONG).show();
                    service = new Intent(context, ElServicio.class);
                    context.stopService(service);
                    break;
            }
        }

    }
}
