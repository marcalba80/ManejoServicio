package com.android.mdw.demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import java.util.Objects;

public class MyReceiver extends BroadcastReceiver {
    private Intent service;

    @Override
    public void onReceive(Context context, Intent intent){

        String opcion = (String) intent.getExtras().get("opcion");

        if (opcion != null) {
            switch (opcion) {
                case "Iniciar Sonido":
                    Toast.makeText(context, "Intent Recibido - Inicio reproduccion Sonido", Toast.LENGTH_LONG).show();
                    service = new Intent(context, ElServicio.class);
                    service.putExtra("opcion", context.getResources().getString(R.string.track));
                    context.startService(service);
                    break;
                case "Iniciar Cancion":
                    Toast.makeText(context, "Intent Recibido - Inicio reproduccion Cancion", Toast.LENGTH_LONG).show();
                    service = new Intent(context, ElServicio.class);
                    service.putExtra("opcion", context.getResources().getString(R.string.song));
                    context.startService(service);
                    break;
                default:
                    Toast.makeText(context, "Intent Recibido - Detencion reproduccion", Toast.LENGTH_LONG).show();
                    service = new Intent(context, ElServicio.class);
                    context.stopService(service);
                    break;
            }
        }
    }
}
