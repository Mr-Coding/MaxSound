package com.frank.maxsound;

import android.content.Context;
import android.media.AudioManager;

public class Control {
    private static AudioManager audioManager;

    public static void max(Context context){
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL); // 取消静音
        audioManager.setStreamVolume(
                AudioManager.STREAM_VOICE_CALL, // 通话
                audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL),
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_RING,   // 铃声
                audioManager.getStreamMaxVolume(AudioManager.STREAM_RING),
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_ALARM, // 提示音
                audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM),
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_NOTIFICATION, // 窗口顶部状态栏Notification
                audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION),
                AudioManager.FLAG_SHOW_UI);
    }

    public static void mute(Context context){
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT); // 静音
        audioManager.setStreamVolume(
                AudioManager.STREAM_MUSIC,  // 媒体
                0,
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_RING,   // 铃声
                0,
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_SYSTEM,   // 系统
                0,
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_ALARM, // 提示音
                0,
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_NOTIFICATION, // 窗口顶部状态栏Notification
                0,
                AudioManager.FLAG_SHOW_UI);
        audioManager.setStreamVolume(
                AudioManager.STREAM_DTMF, // 双音多频
                0,
                AudioManager.FLAG_SHOW_UI);
    }
}
