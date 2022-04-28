package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView have_one;
    EditText name,password;
    Button s_bt;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabase db=new mydatabase(MainActivity.this);
        have_one=findViewById(R.id.have_one);
        name=findViewById(R.id.uname);
        password=findViewById(R.id.upass);
        s_bt=findViewById(R.id.sup_bt);
        s_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = getSharedPreferences("user_details",MODE_PRIVATE);
                String x=name.getText().toString();
                String y=password.getText().toString();
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username",x);
                editor.putString("password",y);
                editor.commit();
                person p=new person(x,y);
                boolean user =db.insertuser(p);
                if(user)
                    Toast.makeText(MainActivity.this,"Signup success",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Signup failed",Toast.LENGTH_SHORT).show();

            }
        });
        have_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(MainActivity.this, com.example.myapplication.login.class);
                startActivity(login);
            }
        });
    }
}
/*

 */