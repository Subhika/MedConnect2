package com.example.medconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.api.TransformedResult;
//import com.google.android.gms.tasks.OnCompleteListener<java.lang.Void>;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class singup extends AppCompatActivity {

    private Button b;
    private EditText firstname;
    // private EditText lastname;
    private EditText email;
    private EditText phone;
    private EditText emiratesid;
    private EditText insuranceid;
    private EditText address1;
    private EditText address2;
    private TextView Gender;
    private RadioButton Male;
    private RadioButton Female;
    private EditText password;
    String gender = "";


    FirebaseDatabase database;
    DatabaseReference db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        firstname = (EditText) findViewById(R.id.fn);
        // lastname = (EditText)findViewById(R.id.ln);
        email = (EditText) findViewById(R.id.ml);
        phone = (EditText) findViewById(R.id.ph);
        emiratesid = (EditText) findViewById(R.id.eid);
        insuranceid = (EditText) findViewById(R.id.inid);
        address1 = (EditText) findViewById(R.id.ad1);
        address2 = (EditText) findViewById(R.id.ad2);
        password = (EditText) findViewById(R.id.passw);
        Gender = (TextView) findViewById(R.id.gender);
        Male = (RadioButton) findViewById(R.id.male);
        Female = (RadioButton) findViewById(R.id.female);
        database = FirebaseDatabase.getInstance();
        db1 = database.getReference("Records");


        b = (Button) findViewById(R.id.nxt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Users user = new Users(firstname.getText().toString(),
                        email.getText().toString(),
                        insuranceid.getText().toString(),
                        emiratesid.getText().toString(),
                        phone.getText().toString(),
                        Gender.getText().toString(),
                        password.getText().toString(),
                        address1.getText().toString(),
                        address2.getText().toString());


                db1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getEmiratedid()).exists()) {
                            Toast.makeText(singup.this, "Already Exist", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!email.getText().toString().equals(""))
                                if (!firstname.getText().toString().equals(""))
                                    if (!insuranceid.getText().toString().equals(""))
                                        if (!phone.getText().toString().equals(""))
                                            if (!address1.getText().toString().equals(""))
                                                if (!address2.getText().toString().equals(""))
                                                    if (!password.getText().toString().equals("")) {
                                                        db1.child(user.getEmiratedid()).setValue(user);
                                                        Toast.makeText(singup.this, "successful", Toast.LENGTH_SHORT).show();
                                                        Intent in = new Intent(singup.this, MainActivity.class);
                                                        in.putExtra("Key", user);
                                                        startActivity(in);
                                                    } else
                                                        Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                                                else
                                                    Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                                            else
                                                Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(singup.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public void main(View view) {
        startActivity(new Intent(singup.this, MainActivity.class));
        finish();
    }
}

