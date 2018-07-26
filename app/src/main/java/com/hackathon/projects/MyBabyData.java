package com.hackathon.projects;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.hackathon.projects.R;

import java.util.Calendar;

public class MyBabyData extends AppCompatActivity {
    private String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_baby_data);

        Button b = findViewById(R.id.baby_record_submit_button);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        final EditText name = findViewById(R.id.person_name);
        final EditText contact = findViewById(R.id.person_contact);
        final EditText disease = findViewById(R.id.disease_baby);
        final EditText loc = findViewById(R.id.person_location);
        final EditText date = findViewById(R.id.date_time_baby);
        final EditText weight = findViewById(R.id.weight_description);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MyBabyData .this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(String.valueOf(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year));
                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String titleString = name.getText().toString();
                if(TextUtils.isEmpty(titleString)){
                    name.setError("REQUIRED");
                    return;
                }
                String dateString = date.getText().toString();
                if(TextUtils.isEmpty(dateString)){
                    date.setError("REQUIRED");
                    return;
                }
                String locString = loc.getText().toString();
                if(TextUtils.isEmpty(locString)){
                    loc.setError("REQUIRED");
                    return;
                }
                String diseaseString = disease.getText().toString();
                if(TextUtils.isEmpty(diseaseString)){
                    disease.setError("REQUIRED");
                    return;
                }

                String contactString = contact.getText().toString();
                if(TextUtils.isEmpty(contactString)){
                    contact.setError("REQUIRED");
                    return;
                }

                String weightString = weight.getText().toString();
                if(TextUtils.isEmpty(weightString)){
                    weight.setError("REQUIRED");
                    return;
                }


                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Name, email address, and profile photo Url

                    email = user.getEmail();


                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getToken() instead.
                    String uid = user.getUid();
                }


                if (titleString.isEmpty() || dateString.isEmpty() || locString.isEmpty()) {
                    Toast.makeText(MyBabyData.this, R.string.toast_empty_fields,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyBabyData.this, R.string.toast_sent, Toast.LENGTH_SHORT).show();
                    BabyData f = new BabyData(titleString,contactString,diseaseString,weightString, locString,dateString,email);
                    myRef.child("baby_record").push().setValue(f);
                    finish();
                }

            }
        });

    }


}
