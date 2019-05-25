package com.example.medconnect;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {

    private EditText medid;
    private EditText pass1;
    private TextView forgotp;
    private Button login;
    private Button signup;
    private int counter = 3;
    private TextView info;
    FirebaseDatabase database;
    DatabaseReference db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        db1 = database.getReference("Records");
        medid = (EditText) findViewById(R.id.mid);
        pass1 = (EditText) findViewById(R.id.pass);
        forgotp = (TextView) findViewById(R.id.fgp);
        login = (Button) findViewById(R.id.loginb);
        signup = (Button) findViewById(R.id.signb);
        info = (TextView) findViewById(R.id.info);


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
                Intent in = new Intent(MainActivity.this, singup.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(medid.getText().toString(), pass1.getText().toString());

            }
        });
    }

    private void validate() {
        counter--;
        medid.setText("");
        pass1.setText("");

        info.setText("No.of incorrect attempts: " + String.valueOf(counter));
        if (counter == 0) {
            login.setEnabled(false);

            new CountDownTimer(60000, 1000) {

                public void onTick(long millisUntilFinished) {
                    info.setText("Please try again in " + millisUntilFinished / 1000 + "s");

                }

                public void onFinish() {
                    login.setEnabled(true);
                    counter = 3;
                    info.setText(" ");
                }
            }.start();


        }
    }

    private void signIn(final String user, final String pass) {
        db1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user).exists()) {
                    if (!user.isEmpty()) {
                        Users login = dataSnapshot.child(user).getValue(Users.class);
                        if (login.getPassword().equals(pass)) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent s = new Intent(getApplicationContext(), Dashboard.class);
                            s.putExtra("Key", user);
                            medid.setText("");
                            pass1.setText("");
                            startActivity(s);
                        } else {
                            Toast.makeText(MainActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                            validate();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Username doesn't exist!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Username doesn't exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
