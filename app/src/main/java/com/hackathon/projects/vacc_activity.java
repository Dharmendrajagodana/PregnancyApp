package com.hackathon.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vaccacine.MyVaccinationDetails;
import vaccacine.VaccinationRecord;

/**
 * Created by anuragsharma on 26/02/18.
 */

public class vacc_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacc_record);

        Button b1 = findViewById(R.id.new_record_btn);
        Button b2 = findViewById(R.id.my_record_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vacc_activity.this, VaccinationRecord.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vacc_activity.this, MyVaccinationDetails.class);
                startActivity(intent);
            }
        });

    }
}
