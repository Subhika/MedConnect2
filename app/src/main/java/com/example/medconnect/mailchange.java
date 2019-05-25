package com.example.medconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mailchange extends AppCompatActivity {

    EditText newmail;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchange);

        newmail = (EditText) findViewById(R.id.new_email);
        sub = (Button) findViewById(R.id.sum_phon);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = newmail.getText().toString();
                if (isValidEmail(email)) {
                    Toast.makeText(view.getContext(), "Email is valid", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext(), "Email is invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static boolean isValidEmail(String email) {
        String expression = "^[\\w\\.]+@([\\w]+\\.)+[A-Z]{2,7}$";
        CharSequence inputString = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
