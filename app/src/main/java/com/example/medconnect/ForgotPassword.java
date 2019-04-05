package com.example.medconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    private TextView forgotpassword;
    private TextView guide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotpassword = (TextView) findViewById(R.id.ft);
        guide = (TextView) findViewById(R.id.guidetext);
    }
}
