package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    TextView not_have;
    EditText nam,pas;
    Button sin_bt;
    // SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  pref = getSharedPreferences("user_details",MODE_PRIVATE);

        mydatabase db=new mydatabase(login.this);

        not_have=findViewById(R.id.not_have);
        nam=findViewById(R.id.unamein);
        pas=findViewById(R.id.upassin);
        sin_bt=findViewById(R.id.sin_bt);
        sin_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z=nam.getText().toString();
                String m=pas.getText().toString();
                //  String name=pref.getString("username",z);
                //  String pas=pref.getString("password",m);

                ArrayList<person> person = db.getuser(z.toString());
                for (person p : person) {
                    String x=p.getPassword();

                    if (m.equals(x) ){

                                Intent intent=new Intent(login.this,NewActivity1.class);
                                startActivity(intent);
                        Toast.makeText(login.this, "login success", Toast.LENGTH_SHORT).show();
                         }
                    else{
                        Toast.makeText(login.this, "login faild try again", Toast.LENGTH_LONG).show();

                    }


                    // Toast.makeText(login.this, "#" + p.getPassword(), Toast.LENGTH_SHORT).show();
                }
            }//p.getPassword()
        });
        not_have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup=new Intent(login.this, MainActivity.class);
                startActivity(signup);
            }
        });
    }
    public void openNewActivity1(){

    }
}