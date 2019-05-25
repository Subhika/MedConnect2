package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class settings extends AppCompatActivity {

    private ImageButton password;
    private ImageButton location;
    private ImageButton creditcard;
    private ImageButton insurancecard;
    private ImageButton phone;
    private ImageButton email;
    private static Users user;
    FirebaseDatabase database = FirebaseDatabase.getInstance();;
    DatabaseReference db;


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

        user = (Users) getIntent().getSerializableExtra("User");

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(settings.this, ForgotPassword.class);
                in.putExtra("User", user);
                startActivity(in);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, mailchange.class);
                in.putExtra("User", user);
                startActivity(in);

            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, codechangepass.class);
                in.putExtra("User", user);
                startActivity(in);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, phonevalidation.class);
                in.putExtra("User", user);
                startActivity(in);

            }
        });
        insurancecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(settings.this, changeinsurance.class);
                in.putExtra("User", user);
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
