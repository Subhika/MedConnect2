package com.example.medconnect;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.sql.Types.NULL;

public class appointment extends AppCompatActivity {

    Spinner hosname;
    Spinner depname;
    Spinner dateto;
    Button sub;
    Spinner timeselected;
    FirebaseDatabase database;
    DatabaseReference db;
  // String user=getIntent().getStringExtra("usern1");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        database=FirebaseDatabase.getInstance();
       db=database.getReference("Appointment");

        depname = (Spinner) findViewById(R.id.department);

       sub = (Button) findViewById(R.id.Submit);
        int _Text_to_Speech_MP3 = 0;
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.merged_arabi_succe);


        final String[] hos = {"Choose Hospital","MedCare - Hadiqa Street", "Al Rashid Hospital ", "Zulekha Hopital - Dubai",
                "MedCare - King Faisal Street", "Zulekha Hospital - Sharjah"};
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hos);
        hosname = (Spinner) findViewById(R.id.hospital);
        hosname.setAdapter(ada);

        ArrayList<String> years = new ArrayList<String>();
        int today = Calendar.getInstance().get(Calendar.DATE);
        for (int i = today; i <=30; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        dateto= (Spinner)findViewById(R.id.date_vi);
        dateto.setAdapter(adapter);

        final String[] time = {"Time","10:00","10:30","11:00","11:30","01:00", "01:30","02:00", "02:30",
                "03:00", "03:30","4:00","4:30"};
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, time);
        timeselected= (Spinner)findViewById(R.id.tym);
        timeselected.setAdapter(adap);


      String[] dep = {"Choose Department","General", "Orthopaedics", "Cardiology",
                "ENT", "Gynaecology", "Pediatrician"};
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dep);
        depname = (Spinner) findViewById(R.id.department);
        depname.setAdapter(adapt);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = hosname.getSelectedItemPosition();
                int post = depname.getSelectedItemPosition();
                int posit = dateto.getSelectedItemPosition();
                int postis = timeselected.getSelectedItemPosition();
                if (pos == 0) {
                    Toast.makeText(appointment.this, "Please Select the Hospital name !!", Toast.LENGTH_LONG).show();
                } else if (post == 0) {
                    Toast.makeText(appointment.this, "Please Select the Department Name !!", Toast.LENGTH_LONG).show();
                }
               else if (posit==NULL)
                {
                    Toast.makeText(appointment.this, "Please Select the Date within next 30 days", Toast.LENGTH_LONG).show();
                }
                else if (postis==NULL)
                {
                    Toast.makeText(appointment.this, "Please Select the Time Slot of your visit", Toast.LENGTH_LONG).show();
                }
                else {
                    String st = hosname.getSelectedItem().toString();
                    String sss = depname.getSelectedItem().toString();
                   String ty = timeselected.getSelectedItem().toString();
                  String da = dateto.getSelectedItem().toString();
                    Toast.makeText(appointment.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    mp.start();
                    finish();
                 // setval(st,sss,ty,da);
               }
            }
            });
        }
       /*public void setval(String h,String d, String t, String dy){
        final appointmenthelp a= new appointmenthelp(h,d,t,dy);
            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(user).exists()){
                        Toast.makeText(appointment.this, "Appointment exists!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        db.child(user).setValue(a);
                        Toast.makeText(appointment.this, "successful", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }*/


    }