package com.vaca.alarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val pendingIntent =
            PendingIntent.getService(this, 0, intent,
                PendingIntent.FLAG_NO_CREATE)
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent)
        }


        alarmManager?.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_HALF_HOUR,
            AlarmManager.INTERVAL_HALF_HOUR,
            alarmIntent
        )
    }
}