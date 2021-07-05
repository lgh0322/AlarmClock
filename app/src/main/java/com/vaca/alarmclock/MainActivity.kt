package com.vaca.alarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       val intent=Intent(this,Da::class.java);
//       val pend=PendingIntent.getService(this,0,intent,PendingIntent.FLAG_ONE_SHOT); //显示闹钟，alarmActivity
        val alarm= getSystemService(Context.ALARM_SERVICE) as (AlarmManager)     // 通过Context.ALARM_SERVICE获取AlarmManager对象

//        alarm.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000,pend);     //设定闹钟

//        alarm.setInexactRepeating(    AlarmManager.ELAPSED_REALTIME_WAKEUP,
//            SystemClock.elapsedRealtime() + 2000,2000,pend);


//        val intent=Intent("com.vaca.alarmclock.fuck")

        val alarmIntent = Intent(this, AlarmReceiver::class.java).let { intent ->
            intent.action="com.vaca.alarmclock.fuck"
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }
//        alarm.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000,alarmIntent);

//
//                alarm.setInexactRepeating(    AlarmManager.ELAPSED_REALTIME_WAKEUP,
//            SystemClock.elapsedRealtime() + 2000,2000,alarmIntent);



        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 7)
        }

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
        alarm.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            1000 *  60*2,
            alarmIntent
        )
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