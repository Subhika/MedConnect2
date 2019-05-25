package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class phonevalidation extends AppCompatActivity {

    Button suu;
    EditText phone_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonevalidation);

        suu = (Button) findViewById(R.id.sum_phon);
        phone_num = (EditText) findViewById(R.id.phone_entry);
        suu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regexStr = "^[0][0-9]{10,12}$";

                String number=phone_num.getText().toString();

                if(phone_num.getText().toString().length()<10 || number.length()>13 || number.matches(regexStr)==false  ) {
                    Toast.makeText(phonevalidation.this, "Please enter a valid phone number",Toast.LENGTH_SHORT).show();
                    // am_checked=0;
                }
                else {
                    Intent i = new Intent(phonevalidation.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
