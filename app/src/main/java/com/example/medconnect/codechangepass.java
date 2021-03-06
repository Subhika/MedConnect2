package com.example.medconnect;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class codechangepass extends AppCompatActivity {

    private EditText passfirst;
    private EditText passsecond;
    private TextView info;
    private TextView info22;
    private Button Submit;
    private static Users user;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codechangepass);

        user = (Users) getIntent().getSerializableExtra("User");

        db = database.getReference("Records").child(user.getInsuranceid()).child("password");

        passfirst = (EditText) findViewById(R.id.pass1);
        passsecond = (EditText) findViewById(R.id.pass2);
        info = (TextView) findViewById(R.id.infotext);
        Submit = (Button) findViewById(R.id.sum_pass);
        info.setVisibility(View.INVISIBLE);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passfirst.getText().toString().length() < 8 && !isValidPassword(passfirst.getText().toString())) {
                    Toast.makeText(codechangepass.this, "Password mismatch with validation", Toast.LENGTH_LONG).show();
                } else {
                    if (passfirst.getText().toString().equals(passsecond.getText().toString())) {
                        db.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                db.setValue(passfirst.getText().toString());
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        info.setVisibility(TextView.INVISIBLE);
                        Toast.makeText(codechangepass.this, "Updation successfull", Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(codechangepass.this,changeinsurance.class);
//                        startActivity(i);
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
