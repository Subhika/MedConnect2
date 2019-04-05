package com.example.medconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Change_Email extends AppCompatActivity {

    private Button submit = (Button)findViewById(R.id.sub_em);
    private EditText newemail = (EditText)findViewById(R.id.new_mail);
    private TextView entertag = (TextView)findViewById(R.id.tag);
    private TextView te = (TextView)findViewById(R.id.text);
    private ImageButton ib = (ImageButton)findViewById(R.id.imageView2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__email);
        //submit = (Button)findViewById(R.id.sub_em);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(Change_Email.this, "Your Email is updated!!",
                         Toast.LENGTH_SHORT).show();
                 Intent in = new Intent(Change_Email.this, settings.class);
                 startActivity(in);
            }
        });
    }
}
