package com.frank.maxsound.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.frank.maxsound.data.Constants;

public class MyBroadcast extends BroadcastReceiver {
    private final static String TAG = "MyBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            Intent i = new Intent(context, MyIntentService.class);

            switch (intent.getAction()) {
                case Constants.MAX:
                    Log.i(TAG,"--- MAX ---");
                    i.setAction(Constants.MAX);
                    break;
                case Constants.MUTE:
                    Log.i(TAG,"--- MUTE ---");
                    i.setAction(Constants.MUTE);
                    break;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                context.startForegroundService(i);
            }else {
                context.startService(i);
            }
        }
    }

}
