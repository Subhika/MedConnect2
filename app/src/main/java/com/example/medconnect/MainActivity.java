package com.example.medconnect;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText medid;
    private EditText pass;
    private TextView forgotp;
    private Button login;
    private Button signup;
    private TextView details;
    private int counter = 3;
    private TextView info;


    //private CountDownTimer cdt;
    //private long timls = 6000;//1 min



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medid = (EditText)findViewById(R.id.mid);
        pass = (EditText)findViewById(R.id.pass);
        forgotp = (TextView) findViewById(R.id.fgp);
        login = (Button) findViewById(R.id.loginb);
        signup = (Button)findViewById(R.id.signb);
        info = (TextView) findViewById(R.id.info);
        //details = (TextView) findViewById(R.id.dtext);

        info.setText("   ");




        forgotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(in);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,singup.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(medid.getText().toString(), pass.getText().toString());
                medid.setText("");
                pass.setText("");
            }
        });
    }

    private void validate(String MedId,String Password){
        if((MedId.equals("ABC123")) && (Password.equals("123"))){
            Intent in = new Intent(MainActivity.this, Dashboard.class);
            startActivity(in);
        }else{
            counter--;
            medid.setText("");
            pass.setText("");

            info.setText("No.of incorrect attempts: " + String.valueOf(counter));



            if(counter == 0){
                login.setEnabled(false);

                new CountDownTimer(60000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        info.setText("Please try again in " + millisUntilFinished / 1000 +"s");

                    }

                    public void onFinish() {
                        login.setEnabled(true);
                        counter = 3;
                        info.setText(" ");
                    }
                }.start();


            }
        }
    }
}
