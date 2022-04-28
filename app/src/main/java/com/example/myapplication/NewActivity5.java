package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewActivity5 extends AppCompatActivity {
    ImageView bl_start,bl_stop;
    ImageView syt_start,syt_stop;
    ImageView tmb_start,tmb_stop;
    ImageView g_start,g_stop;
    int currentID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new5);


        bl_start = (ImageView) findViewById(R.id.image1_1);
        bl_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=1;
                stopService2();
                stopService3();
                stopService4();
                openService1();
            }
        });

        bl_stop = (ImageView) findViewById(R.id.image1_2);
        bl_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(1))
                    stopService1();

            }
        });





        syt_start= (ImageView) findViewById(R.id.image2_1);
        syt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=2;
                stopService1();
                stopService3();
                stopService4();


                openService2();
            }
        });

        syt_stop= (ImageView) findViewById(R.id.image2_2);
        syt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(2))
                    stopService2();
            }
        });


        tmb_start= (ImageView) findViewById(R.id.image3_1);
        tmb_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=3;
                stopService1();
                stopService2();
                stopService4();


                openService3();
            }
        });

        tmb_stop= (ImageView) findViewById(R.id.image3_2);
        tmb_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(3))
                    stopService3();
            }
        });




        g_start= (ImageView) findViewById(R.id.image4_1);
        g_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=4;
                stopService1();
                stopService2();
                stopService3();


                openService4();
            }
        });

        g_stop= (ImageView) findViewById(R.id.image4_2);
        g_stop.setOnClickListener(new View.OnClickListener() {
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

//blinding lights

    public void openService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.bl);
        startService(intent);
    }

    public void stopService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.bl);
        stopService(intent);
    }

    //save your tears
    public void openService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.syt);
        startService(i);
    }

    public void stopService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.syt);
        stopService(i);
    }

    //take my breath
    public void openService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.tmb);
        startService(i);
    }

    public void stopService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.tmb);
        stopService(i);
    }

    //gasoline

    public void openService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.g);
        startService(i);
    }

    public void stopService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.g);
        stopService(i);
    }


}