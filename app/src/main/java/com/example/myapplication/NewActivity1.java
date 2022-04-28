package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;


public class NewActivity1 extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;


    private Button buttonOpenURL;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);


        this.buttonOpenURL = (Button) this.findViewById(R.id.button_openURL);
        this.buttonOpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL1(); }
        });


        button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

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
    // The method is called when the user clicks on "Open google.com" button.
    public void openURL1(){
        String url = "https://www.wikipedia.org/";

        // An implicit intent, request a URL.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }
    //explicit intent directly call an activity
    public void openActivity2(){
        Intent intent  = new Intent (this, NewActivity2.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent  = new Intent (this, NewActivity3.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent  = new Intent (this, NewActivity4.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent  = new Intent (this, NewActivity5.class);
        startActivity(intent);
    }


    public void push(View view) {
        notificationManagerCompat.notify(1,notification);
    }
}