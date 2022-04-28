package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewActivity3 extends AppCompatActivity {
    ImageView b_start,b_stop;
    ImageView wit_start,wit_stop;
    ImageView n_start,n_stop;
    ImageView t_start,t_stop;
    int currentID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);

        b_start = (ImageView) findViewById(R.id.image1_1);
        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=1;
                stopService2();
                stopService3();
                stopService4();


                openService1();
            }
        });

        b_stop = (ImageView) findViewById(R.id.image1_2);
        b_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(1))
                    stopService1();

            }
        });





        wit_start= (ImageView) findViewById(R.id.image2_1);
        wit_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=2;
                stopService1();
                stopService3();
                stopService4();


                openService2();
            }
        });

        wit_stop= (ImageView) findViewById(R.id.image2_2);
        wit_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(2))
                    stopService2();
            }
        });


        n_start= (ImageView) findViewById(R.id.image3_1);
        n_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=3;
                stopService1();
                stopService2();
                stopService4();


                openService3();
            }
        });

        n_stop= (ImageView) findViewById(R.id.image3_2);
        n_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(3))
                    stopService3();
            }
        });




        t_start= (ImageView) findViewById(R.id.image4_1);
        t_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=4;
                stopService1();
                stopService2();
                stopService3();


                openService4();
            }
        });

        t_stop= (ImageView) findViewById(R.id.image4_2);
        t_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(4))
                    stopService4();
            }
        });

    }

    private boolean isMyServiceRunning(int idService){
        return idService==currentID ;
    }

//beliver

    public void openService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.b);
        startService(intent);
    }

    public void stopService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.b);
        stopService(intent);
    }

    //whatever it takes
    public void openService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.wit);
        startService(i);
    }

    public void stopService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.wit);
        stopService(i);
    }

    //natural
    public void openService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.n);
        startService(i);
    }

    public void stopService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.n);
        stopService(i);
    }

    //thunder

    public void openService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.t);
        startService(i);
    }

    public void stopService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.t);
        stopService(i);
    }


}