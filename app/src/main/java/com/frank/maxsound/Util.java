package com.frank.maxsound;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RemoteViews;

import com.frank.maxsound.activity.BaseActivity;
import com.frank.maxsound.data.Constants;
import com.frank.maxsound.data.Data;
import com.frank.maxsound.service.MyBroadcast;
import com.frank.maxsound.view.WidgetBackground;

import static android.content.Context.NOTIFICATION_SERVICE;


public class Util {

    // 向本类发送特定的Action广播
    public static PendingIntent onClickPendingIntent(Context context, String strigAction,Class<?> zlass){
        Intent intent = new Intent(context,zlass);
        intent.setAction(strigAction);
        return PendingIntent.getBroadcast(context,0,intent,0);
    }

    // 设置 Max widget 里的相应内容
    public static void updateMaxAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        int color = new Data(context, Constants.MAX_DATA).getColor(Constants.Colors[0]);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.max);
        WidgetBackground background = new WidgetBackground(context);
        background.setColor(color);
        background.measure(150,150);
        background.layout(0,0,150,150);
        background.setDrawingCacheEnabled(true);
        Bitmap bitmap = background.getDrawingCache();
        views.setImageViewBitmap(R.id.maxBtn,bitmap);

        views.setOnClickPendingIntent(R.id.max_layout, Util.onClickPendingIntent(context, Constants.MAX,MyBroadcast.class));
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    // 设置 Mute widget 里的相应内容
    public static void updateMuteAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        int color = new Data(context,Constants.MUTE_DATA).getColor(Constants.Colors[0]);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mute);
        WidgetBackground background = new WidgetBackground(context);
        background.setColor(color);
        background.measure(150,150);
        background.layout(0,0,150,150);
        background.setDrawingCacheEnabled(true);
        Bitmap bitmap = background.getDrawingCache();
        views.setImageViewBitmap(R.id.muteBtn,bitmap);

        views.setOnClickPendingIntent(R.id.mute_layout, Util.onClickPendingIntent(context, Constants.MUTE,MyBroadcast.class));
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void permissionDialog(final Context context){
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && !manager.isNotificationPolicyAccessGranted()) {

            new AlertDialog.Builder(context).setTitle("Android6.0及以上需要获取\"勿扰\"模式的权限哦! (●'◡'●)")
                    .setIcon(R.drawable.icon_info)
                    .setPositiveButton("授权", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                            context.startActivity(intent);
                        }
                    }).setNegativeButton("退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((Activity)context).finish();
                }
            }).setCancelable(false).show();

        }
    }

}
