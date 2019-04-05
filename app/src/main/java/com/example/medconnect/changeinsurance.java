package com.example.medconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class changeinsurance extends AppCompatActivity {

    private EditText name_ins;
    private EditText type_ins;
    private Spinner year;
    private Button sub_ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeinsurance);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i <= thisYear+10; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        name_ins = (EditText)findViewById(R.id.ins_name);
        type_ins = (EditText)findViewById(R.id.ins_type);
        year = (Spinner)findViewById(R.id.exdate);
        year.setAdapter(adapter);
        sub_ins = (Button)findViewById(R.id.Sub_ins);

        sub_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name_ins.getText().toString().equals("")|
                        type_ins.getText().toString().equals(""))
                    Toast.makeText(changeinsurance.this, "Fields are empty!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(changeinsurance.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
