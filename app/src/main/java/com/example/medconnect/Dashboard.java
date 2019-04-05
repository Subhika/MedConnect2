package com.example.medconnect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private Button consultation;
    private TextView problems;
    private Button prescription;
    private Button statofdelivery;
    ImageButton logout;
    ImageButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        consultation = (Button) findViewById(R.id.conb);
        problems = (TextView) findViewById(R.id.fap);
        prescription = (Button) findViewById(R.id.presb);
        statofdelivery = (Button) findViewById(R.id.sdb);
        logout = (ImageButton) findViewById(R.id.logoutb);
        settings = (ImageButton) findViewById(R.id.set);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, Addressdelivery.class);
                startActivity(in);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Dashboard.this, settings.class);
                startActivity(in);
            }
        });


    }



    }

