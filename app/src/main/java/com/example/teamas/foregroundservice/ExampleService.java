package com.example.teamas.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class ExampleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {    // called the first time we create our service
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {   // called every time we call startService()
        String input = intent.getStringExtra("Input");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_ID_1)
                .setContentTitle("Notification")
                .setContentText(input)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent)
                .build();

        // normally when we display notification we call notify() on notification manager but here we can use our service and
        // service does that itself for us

        startForeground(1, notification);
        return START_NOT_STICKY;     // this defines what happens what system kill our service
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
