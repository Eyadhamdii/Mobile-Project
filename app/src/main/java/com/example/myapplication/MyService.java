package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer mp;


    public MyService() {
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int filePath = intent.getIntExtra("filePath", R.raw.rid);
        mp = mp.create(this, filePath);
        if (!mp.isPlaying())
            mp.start();
        return START_STICKY;

    }
        @Override
        public void onDestroy () {
            Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
            super.onDestroy();
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            }
        }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}






