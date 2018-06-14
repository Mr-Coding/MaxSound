package com.frank.maxsound.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.frank.maxsound.R;
import com.frank.maxsound.Util;

public class Mute extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Util.updateMuteAppWidget(context,appWidgetManager,appWidgetId);
        }
    }

}

