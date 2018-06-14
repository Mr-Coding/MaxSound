package com.frank.maxsound.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.frank.maxsound.Util;
import com.frank.maxsound.data.Constants;
import com.frank.maxsound.view.ColorCheck;
import com.github.clans.fab.FloatingActionButton;

import com.frank.maxsound.R;
import com.frank.maxsound.view.StatusBarUtils;

public class BaseActivity extends Activity implements ColorCheck.OnCheckChangedListener {
    private   FloatingActionButton fab;
    protected ColorCheck colorCheck1,colorCheck2,colorCheck3,colorCheck4,colorCheck5;
    protected ColorCheck colorCheck6,colorCheck7,colorCheck8,colorCheck9,colorCheck10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configure_activity);

        init();

        StatusBarUtils.setWindowStatusBarColor(this,R.color.colorPrimary);

        Util.permissionDialog(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onFABClick();
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Util.permissionDialog(this);
    }

    public void init(){
        fab = findViewById(R.id.fab);

        colorCheck1 = findViewById(R.id.color1);
        colorCheck1.setColor(Constants.Colors[0]);
        colorCheck1.setOnCheckChangedListener(this);

        colorCheck2 = findViewById(R.id.color2);
        colorCheck2.setColor(Constants.Colors[1]);
        colorCheck2.setOnCheckChangedListener(this);

        colorCheck3 = findViewById(R.id.color3);
        colorCheck3.setColor(Constants.Colors[2]);
        colorCheck3.setOnCheckChangedListener(this);

        colorCheck4 = findViewById(R.id.color4);
        colorCheck4.setColor(Constants.Colors[3]);
        colorCheck4.setOnCheckChangedListener(this);

        colorCheck5 = findViewById(R.id.color5);
        colorCheck5.setColor(Constants.Colors[4]);
        colorCheck5.setOnCheckChangedListener(this);

        colorCheck6 = findViewById(R.id.color6);
        colorCheck6.setColor(Constants.Colors[5]);
        colorCheck6.setOnCheckChangedListener(this);

        colorCheck7 = findViewById(R.id.color7);
        colorCheck7.setColor(Constants.Colors[6]);
        colorCheck7.setOnCheckChangedListener(this);

        colorCheck8 = findViewById(R.id.color8);
        colorCheck8.setColor(Constants.Colors[7]);
        colorCheck8.setOnCheckChangedListener(this);

        colorCheck9 = findViewById(R.id.color9);
        colorCheck9.setColor(Constants.Colors[8]);
        colorCheck9.setOnCheckChangedListener(this);

        colorCheck10 = findViewById(R.id.color10);
        colorCheck10.setColor(Constants.Colors[9]);
        colorCheck10.setOnCheckChangedListener(this);

    }

    @Override
    public void onCheckChanged(boolean isChecked, int ID) {

    }

    public void onFABClick(){

    }
}
