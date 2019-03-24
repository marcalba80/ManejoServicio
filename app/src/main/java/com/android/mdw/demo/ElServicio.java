package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer song, track;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();

		//player = MediaPlayer.create(this, R.raw.train);
		//player.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		if(track != null) track.stop();
		if(song != null) song.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		//Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		String opcion = (String) intent.getExtras().get("opcion");
		//System.out.println(opcion);

		switch(opcion){
			case "Iniciar Sonido":
				Toast.makeText(this, "Servicio Sonido iniciado", Toast.LENGTH_LONG).show();
				if (track != null && track.isPlaying())  {
					track.stop();
					track.release();
				}
				track = MediaPlayer.create(this, R.raw.train);
				track.setLooping(true);
				track.start();
				break;
			case "Iniciar Cancion":
				Toast.makeText(this, "Servicio Cancion iniciado", Toast.LENGTH_LONG).show();
				if (song != null && song.isPlaying())  {
					song.stop();
					song.release();
				}
				song = MediaPlayer.create(this, R.raw.song);
				song.setLooping(true);
				song.start();
				break;
		}
		return startid;		
	}	

}
