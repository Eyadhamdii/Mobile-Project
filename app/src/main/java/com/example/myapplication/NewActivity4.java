package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewActivity4 extends AppCompatActivity {
    ImageView amp_start,amp_stop;
    ImageView lf_start,lf_stop;
    ImageView lp_start,lp_stop;
    ImageView og_start,og_stop;
    int currentID ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new4);

        amp_start = (ImageView) findViewById(R.id.image1_1);
        amp_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=1;
                stopService2();
                stopService3();
                stopService4();


                openService1();
            }
        });

        amp_stop = (ImageView) findViewById(R.id.image1_2);
        amp_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(1))
                    stopService1();

            }
        });





        lf_start= (ImageView) findViewById(R.id.image2_1);
        lf_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=2;
                stopService1();
                stopService3();
                stopService4();


                openService2();
            }
        });

        lf_stop= (ImageView) findViewById(R.id.image2_2);
        lf_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(2))
                    stopService2();
            }
        });


        lp_start= (ImageView) findViewById(R.id.image3_1);
        lp_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=3;
                stopService1();
                stopService2();
                stopService4();

                openService3();
            }
        });

        lp_stop= (ImageView) findViewById(R.id.image3_2);
        lp_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(3))
                    stopService3();
            }
        });




        og_start= (ImageView) findViewById(R.id.image4_1);
        og_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentID=4;
                stopService1();
                stopService2();
                stopService3();


                openService4();
            }
        });

        og_stop= (ImageView) findViewById(R.id.image4_2);
        og_stop.setOnClickListener(new View.OnClickListener() {
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

    //Adieu mon pays
    public void openService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.amp);
        startService(intent);
    }

    public void stopService1() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("filePath",R.raw.amp);
        stopService(intent);
    }

    //La Femme de Mon Ami
    public void openService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.lf);
        startService(i);
    }

    public void stopService2() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.lf);
        stopService(i);
    }

    //Les Filles De Mon Pays
    public void openService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.lp);
        startService(i);
    }

    public void stopService3() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.lp);
        stopService(i);
    }

    //Oh Guitare

    public void openService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.og);
        startService(i);
    }

    public void stopService4() {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("filePath",R.raw.og);
        stopService(i);
    }


}