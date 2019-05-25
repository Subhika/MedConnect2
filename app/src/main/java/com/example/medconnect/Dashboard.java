package com.example.medconnect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private ImageButton consultation;
    private TextView problems;
    private ImageButton prescription;
    private ImageButton statofdelivery;
    private Button logout;
    private Button settings;
    private ImageButton hospitallist;
    private static Users user;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        consultation = (ImageButton) findViewById(R.id.appointment1);
        problems = (TextView) findViewById(R.id.fap);
        prescription = (ImageButton) findViewById(R.id.presb);
        hospitallist = (ImageButton) findViewById(R.id.hoslist);
        statofdelivery = (ImageButton) findViewById(R.id.sdb);
        logout = (Button) findViewById(R.id.logoutb);
        settings = (Button) findViewById(R.id.set);

        user = (Users) getIntent().getSerializableExtra("Key");

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, MainActivity.class);
                startActivity(in);
            }
        });

        consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, appointment.class);
                in.putExtra("User", user);
                startActivity(in);
            }
        });

        hospitallist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, hospital.class);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, settings.class);
                in.putExtra("User", user);
                startActivity(in);
            }
        });


    }


}

