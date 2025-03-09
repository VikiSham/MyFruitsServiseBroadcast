package com.example.myfruits;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyServiceMusic extends Service {
    private MediaPlayer player;

    public MyServiceMusic() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.waterswamp);
        player.setLooping(true);
        player.setVolume(1.0f,1.0f);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId)
    {
        if (player != null && !player.isPlaying()) {
            player.start();
        }
        return START_STICKY; // מבטיח שהשירות יופעל מחדש אם ייסגר
    }
    @Override
    public void onDestroy()
    {
        if (player != null) {
            player.stop();
            player.release(); // שחרור המשאב
            player = null;
        }
        super.onDestroy();
    }

}