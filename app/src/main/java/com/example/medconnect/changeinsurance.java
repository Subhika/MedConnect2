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

    private Spinner name_ins;
    private Spinner type_ins;
    private Spinner year;
    private Button sub_ins;
    public String insnameselct;
    public String instypeselct;
    public int intyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeinsurance);

        sub_ins = (Button) findViewById(R.id.Sub_ins);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i <= thisYear + 5; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        year = (Spinner) findViewById(R.id.exdate);
        year.setAdapter(adapter);

        String[] insuname = {"Choose Insurance", "Afia", "FMC", "NextCare"};
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, insuname);
        name_ins = (Spinner) findViewById(R.id.ins_na);
        name_ins.setAdapter(ada);

        String[] instype = {"Choose Insurance policy", "Gold", "Silver", "A-grade"};
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instype);
        type_ins = (Spinner) findViewById(R.id.ins_typ);
        type_ins.setAdapter(adap);


        sub_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = name_ins.getSelectedItemPosition();
                int post = type_ins.getSelectedItemPosition();
                int posit = year.getSelectedItemPosition();
                if (pos == 0) {
                    Toast.makeText(changeinsurance.this, "Please Select the Insurance name !!", Toast.LENGTH_LONG).show();
                } else if (post == 0) {
                    Toast.makeText(changeinsurance.this, "Please Select the Insurance type !!", Toast.LENGTH_LONG).show();
                } else if (posit == 0) {
                    Toast.makeText(changeinsurance.this, "Please Select the Expiry year !!", Toast.LENGTH_LONG).show();
                } else {
                    String st = name_ins.getSelectedItem().toString();
                    String sss = type_ins.getSelectedItem().toString();
                    Toast.makeText(changeinsurance.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
