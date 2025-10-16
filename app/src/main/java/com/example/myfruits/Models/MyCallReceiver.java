package com.example.myfruits.Models;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Intent musicIntent = new Intent(context, MyServiceMusic.class);

        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state) ||
                TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
            Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show();
            context.stopService(musicIntent);
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
            Toast.makeText(context, "Idle", Toast.LENGTH_SHORT).show();
            context.startService(musicIntent);
        }
    }
}