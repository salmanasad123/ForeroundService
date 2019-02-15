package com.example.teamas.foregroundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationApp extends Application {

    public static final String CHANNEL_ID_1 = "channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }


    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH);

            notificationChannel1.enableLights(false);
            notificationChannel1.setDescription("This is Channel 1");
            notificationChannel1.enableVibration(false);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel1);
            }

        }
    }
}
