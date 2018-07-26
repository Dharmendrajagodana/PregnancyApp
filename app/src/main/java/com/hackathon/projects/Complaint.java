package com.hackathon.projects;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hackathon.projects.R;

public class Complaint extends AppCompatActivity {
    ProgressDialog pDialog;
    String name="John", email="john@xyz.com", contact="45487589", detail="Bad services";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_health_details);

        EditText nameEditText = findViewById(R.id.person_name);
        name = nameEditText.getText().toString();

        EditText emailEditText = findViewById(R.id.person_email);
        email = emailEditText.getText().toString();

        EditText contactEditText = findViewById(R.id.person_contact);
        contact = contactEditText.getText().toString();

        EditText weightEditText = findViewById(R.id.weight_description);
        detail = weightEditText.getText().toString();

        Button b = findViewById(R.id.baby_record_submit_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
