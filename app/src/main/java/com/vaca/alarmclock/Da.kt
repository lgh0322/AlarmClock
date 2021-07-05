package com.vaca.alarmclock

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class Da:Service() {
    override fun onCreate() {
        super.onCreate()
        Log.e("sdf","四道口附近开了开了")
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}