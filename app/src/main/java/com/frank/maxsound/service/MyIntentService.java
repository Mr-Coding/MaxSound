package com.frank.maxsound.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.frank.maxsound.Control;
import com.frank.maxsound.R;
import com.frank.maxsound.data.Constants;

public class MyIntentService extends IntentService {
    private final static String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"--- MyIntentService ---");

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                && !manager.isNotificationPolicyAccessGranted()) {
            Intent i = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(i);
            return super.onStartCommand(intent, flags, startId);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new Notification.Builder(this, Constants.CHANGE_VOLUME_CHANNEL_ID).
                    setContentTitle(getString(R.string.app_name)+"正在后台运行").
                    setSmallIcon(R.drawable.icon_check).
                    build();
            startForeground(1,notification);
        }

        switch (intent.getAction()){
            case Constants.MAX:
                Log.i(TAG,"MAX...");
                Control.max(getApplicationContext());
                break;
            case Constants.MUTE:
                Log.i(TAG,"MUTE...");
                Control.mute(getApplicationContext());
                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) { }

}
