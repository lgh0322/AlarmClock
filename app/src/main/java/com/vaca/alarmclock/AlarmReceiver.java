package com.vaca.alarmclock;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("fuck".equals(intent.getAction())) {
            // 第1步中设置的闹铃时间到，这里可以弹出闹铃提示并播放响铃
            Toast.makeText(context, "hello alarm", Toast.LENGTH_LONG).show();
            Log.e("fcuk","圣诞节快乐附近开了");
            // 可以继续设置下一次闹铃时间;
            return;
        }
    }
}