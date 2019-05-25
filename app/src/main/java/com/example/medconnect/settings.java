package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class settings extends AppCompatActivity {

    private ImageButton password;
    private ImageButton location;
    private ImageButton creditcard;
    private ImageButton insurancecard;
    private ImageButton phone;
    private ImageButton email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        password = (ImageButton) findViewById(R.id.pass);
        location = (ImageButton) findViewById(R.id.presb);
        creditcard = (ImageButton) findViewById(R.id.creditcard);
        insurancecard = (ImageButton) findViewById(R.id.insurance);
        phone = (ImageButton) findViewById(R.id.hoslist);
        email = (ImageButton) findViewById(R.id.mail);


        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(settings.this, ForgotPassword.class);
                startActivity(in);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, mailchange.class);
                startActivity(in);

            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, codechangepass.class);
                startActivity(in);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, phonevalidation.class);
                startActivity(in);

            }
        });
        insurancecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, changeinsurance.class);
                startActivity(in);

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent in = new Intent(settings.this, Addressdelivery.class);
                //startActivity(in);

            }
        });
    }
}
