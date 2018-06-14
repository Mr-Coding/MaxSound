package com.frank.maxsound.activity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;

import com.frank.maxsound.R;
import com.frank.maxsound.Util;
import com.frank.maxsound.data.Constants;
import com.frank.maxsound.data.Data;

public class MuteConfigureActivity extends BaseActivity {
    private int  mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setResult(RESULT_CANCELED);
        super.onCreate(savedInstanceState);

        initAppWidgetId();

        data = new Data(this,Constants.MUTE_DATA);
    }

    //配置和检测mAppWidgetId
    private void initAppWidgetId(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
    }

    @Override
    public void onFABClick() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(MuteConfigureActivity.this);
        Util.updateMuteAppWidget(MuteConfigureActivity.this,appWidgetManager,mAppWidgetId);

        Intent i = new Intent();
        i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,mAppWidgetId);
        setResult(RESULT_OK,i);
        finish();
    }

    @Override
    public void onCheckChanged(boolean isChecked, int ID) {
        super.onCheckChanged(isChecked, ID);
        int color = 0;
        colorCheck1.setChecked((ID == colorCheck1.getId()));
        colorCheck2.setChecked((ID == colorCheck2.getId()));
        colorCheck3.setChecked((ID == colorCheck3.getId()));
        colorCheck4.setChecked((ID == colorCheck4.getId()));
        colorCheck5.setChecked((ID == colorCheck5.getId()));
        colorCheck6.setChecked((ID == colorCheck6.getId()));
        colorCheck7.setChecked((ID == colorCheck7.getId()));
        colorCheck8.setChecked((ID == colorCheck8.getId()));
        colorCheck9.setChecked((ID == colorCheck9.getId()));
        colorCheck10.setChecked((ID == colorCheck10.getId()));
        switch (ID){
            case R.id.color1:
                color = Constants.Colors[0];
                break;
            case R.id.color2:
                color = Constants.Colors[1];
                break;
            case R.id.color3:
                color = Constants.Colors[2];
                break;
            case R.id.color4:
                color = Constants.Colors[3];
                break;
            case R.id.color5:
                color = Constants.Colors[4];
                break;
            case R.id.color6:
                color = Constants.Colors[5];
                break;
            case R.id.color7:
                color = Constants.Colors[6];
                break;
            case R.id.color8:
                color = Constants.Colors[7];
                break;
            case R.id.color9:
                color = Constants.Colors[8];
                break;
            case R.id.color10:
                color = Constants.Colors[9];
                break;
        }
        data.saveColor(color);
    }
}
