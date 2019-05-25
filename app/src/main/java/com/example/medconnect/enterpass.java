package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class enterpass extends AppCompatActivity {

    private EditText passfirst;
    private EditText passsecond;
    private TextView info;
    private TextView info22;
    private Button Submit;
    private TextView medIDdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpass);

        passfirst = (EditText) findViewById(R.id.pass1);
        passsecond = (EditText) findViewById(R.id.pass2);
        info = (TextView) findViewById(R.id.infotext);
        Submit = (Button) findViewById(R.id.sum_pass);
        info.setVisibility(View.INVISIBLE);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passfirst.getText().toString().length() < 8 && !isValidPassword(passfirst.getText().toString())) {
                    Toast.makeText(enterpass.this, "Password mismatch with validation", Toast.LENGTH_LONG).show();
                } else {
                    if (passfirst.getText().toString().equals(passsecond.getText().toString())) {
                        info.setVisibility(TextView.INVISIBLE);

                        Toast.makeText(enterpass.this, "Updation successfull", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(enterpass.this, signupreg.class);
                        startActivity(in);

                    } else
                        info.setVisibility(TextView.VISIBLE);

                }

            }
        });


    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();


    }
}
