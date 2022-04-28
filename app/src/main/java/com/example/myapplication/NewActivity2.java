package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewActivity2 extends AppCompatActivity {
    ImageView rid_start,rid_stop;
    ImageView h_start,h_stop;
    ImageView eom_start,eom_stop;
    ImageView omg_start,omg_stop;
    int currentID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);



        rid_start = (ImageView) findViewById(R.id.image1_1);
        rid_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=1;
                stopService2();
                stopService3();
                stopService4();


                openService1();
            }
        });

        rid_stop = (ImageView) findViewById(R.id.image1_2);
        rid_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(1))
                    stopService1();

            }
        });





        h_start= (ImageView) findViewById(R.id.image2_1);
        h_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=2;
                stopService1();
                stopService3();
                stopService4();


                openService2();
            }
        });

        h_stop= (ImageView) findViewById(R.id.image2_2);
        h_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(2))
                    stopService2();
            }
        });


        eom_start= (ImageView) findViewById(R.id.image3_1);
        eom_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=3;
                stopService1();
                stopService2();
                stopService4();


                openService3();
            }
        });

        eom_stop= (ImageView) findViewById(R.id.image3_2);
       eom_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(3))
                    stopService3();
            }
        });




        omg_start= (ImageView) findViewById(R.id.image4_1);
        omg_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=4;
                stopService1();
                stopService2();
                stopService3();


                openService4();
            }
        });

        omg_stop= (ImageView) findViewById(R.id.image4_2);
        omg_stop.setOnClickListener(new View.OnClickListener() {
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

//rolling in the deep

    public void openService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.rid);
        startService(intent);
    }

    public void stopService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.rid);
        stopService(intent);
    }

    //hello
    public void openService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.h);
        startService(i);
    }

    public void stopService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.h);
        stopService(i);
    }

    //easy on me
    public void openService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.eom);
        startService(i);
    }

    public void stopService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.eom);
        stopService(i);
    }

    //oh my god

    public void openService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.omg);
        startService(i);
    }

    public void stopService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.omg);
        stopService(i);
    }






}