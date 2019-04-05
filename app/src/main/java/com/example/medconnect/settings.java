package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    private Button ch_mail;
    private Button ch_pass;
    private Button ch_phone;
    private Button ch_insu;
    private Button ch_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ch_mail = (Button)findViewById(R.id.c_mail);
        ch_pass = (Button)findViewById(R.id.c_pass);
        ch_phone = (Button)findViewById(R.id.c_phone);
        ch_insu = (Button)findViewById(R.id.c_insu);
        ch_loc = (Button)findViewById(R.id.c_loc);

        /*forgotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(in);
            }
        });*/

        ch_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, Change_Email.class);
                startActivity(in);

            }
        });
        ch_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, codechangepass.class);
                startActivity(in);
            }
        });
        ch_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent(settings.this, Change_Email.class);
                //startActivity(in);

            }
        });
        ch_insu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, changeinsurance.class);
                startActivity(in);

            }
        });
        ch_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent(settings.this, Change_Email.class);
                //startActivity(in);

            }
        });
    }
}
