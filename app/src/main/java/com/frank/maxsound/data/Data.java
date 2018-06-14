package com.frank.maxsound.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.*;

public class Data {
    private SharedPreferences sharedPreferences;
    private Editor            editor;

    public Data(Context context, String dataName){
        sharedPreferences = context.getSharedPreferences(dataName,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public int getColor(int initColorIndex){
        return sharedPreferences.getInt("color",initColorIndex);
    }
    public boolean saveColor(int colorIndex){
        return editor.putInt("color",colorIndex).commit();
    }


}
