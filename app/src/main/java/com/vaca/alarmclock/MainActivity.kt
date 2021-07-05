package com.vaca.alarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val intent=Intent(this,Da::class.java);
       val pend=PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT); //显示闹钟，alarmActivity
        val alarm= getSystemService(Context.ALARM_SERVICE) as (AlarmManager)     // 通过Context.ALARM_SERVICE获取AlarmManager对象

        alarm.set(AlarmManager.RTC,System.currentTimeMillis()+1000,pend);     //设定闹钟

    }


    private fun setAlarmTime(context: Context, triggerAtMillis: Long) {
        val am = context.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent("android.alarm.demo.action")
        val sender = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        )

        am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), sender)
    }
}