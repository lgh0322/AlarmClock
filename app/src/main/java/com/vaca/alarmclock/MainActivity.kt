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
       val intent=Intent(this,MainActivity2::class.java);
       val pend=PendingIntent.getActivity(this,0,intent,0); //显示闹钟，alarmActivity
        val alarm= getSystemService(Context.ALARM_SERVICE) as (AlarmManager)     // 通过Context.ALARM_SERVICE获取AlarmManager对象
      val calendar = Calendar.getInstance();                     //获取日历对象
        calendar.set(Calendar.HOUR_OF_DAY,18);       //利用时间拾取组件timePicker得到要设定的时间
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
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