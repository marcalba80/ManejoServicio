package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
  private Intent in;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button btnInicio = (Button) findViewById(R.id.btnInicio);
    Button btnFin = (Button) findViewById(R.id.btnFin);
    Button btnTrack = (Button) findViewById(R.id.button1);
    Button btnSong = (Button) findViewById(R.id.button2);
    Button btnStop = (Button) findViewById(R.id.button3);

    btnInicio.setOnClickListener(this);
    btnFin.setOnClickListener(this);
    btnTrack.setOnClickListener(this);
    btnSong.setOnClickListener(this);
    btnStop.setOnClickListener(this);
  }

  public void onClick(View src) {
    switch (src.getId()) {
      case R.id.btnInicio:
        startService(new Intent(this, ElServicio.class));
        break;
      case R.id.btnFin:
        stopService(new Intent(this, ElServicio.class));
        break;
      case R.id.button1:
        Toast.makeText(this, "Seleccionado Sonido", Toast.LENGTH_LONG).show();
        in = new Intent(this, ElServicio.class);
        in.putExtra("opcion", getResources().getString(R.string.track));
        System.out.println("button1");
        startService(in);
        break;
      case R.id.button2:
        Toast.makeText(this, "Seleccionado Cancion", Toast.LENGTH_LONG).show();
        in = new Intent(this, ElServicio.class);
        in.putExtra("opcion", getResources().getString(R.string.song));
        startService(in);
        break;
      case R.id.button3:
        stopService(in);
        break;
    }
  }
}