package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class not extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("mych","my channel", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"mych")
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle("first notification")
                .setContentText("This is the body of message");
        notification = builder.build();
        notificationManagerCompat=NotificationManagerCompat.from(this);
    }

    public void push(View view) {
        notificationManagerCompat.notify(1,notification);
    }
}