package vaccacine;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.projects.R;

import java.util.ArrayList;
import java.util.Calendar;

public class VaccinationRecord extends AppCompatActivity {

    ArrayList<String> vaccineList = new ArrayList<>();
    private String email = "";
    private String name = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_record);

        Button b = findViewById(R.id.vacc_submit_button);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        //final EditText title = (EditText) findViewById(R.id.vacc_name);
        vaccineList.add("Hepatitus B");
        vaccineList.add("BCG");
        vaccineList.add("Poliovirus");
        vaccineList.add("DTP");
        vaccineList.add("Hib");
        vaccineList.add("Pneumonia");
        vaccineList.add("RV");
        vaccineList.add("Typhoid");
        vaccineList.add("Varicella");

        // district
        final Spinner vacc_spinner = findViewById(R.id.vacc_name);
        ArrayAdapter<String> vaccine_adapter = new ArrayAdapter<>(VaccinationRecord.this, android.R.layout.simple_spinner_item, vaccineList);
        vaccine_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vacc_spinner.setAdapter(vaccine_adapter);
        final EditText date = findViewById(R.id.vacc_date);
        final EditText loc = findViewById(R.id.vacc_loc);

        // type_spinner item
        vacc_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(VaccinationRecord.this,
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


                String titleString = name;
                String dateString = date.getText().toString();
                String locString = loc.getText().toString();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Name, email address, and profile photo Url
                    name = user.getDisplayName();
                    email = user.getEmail();


                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getToken() instead.
                    String uid = user.getUid();
                }


                if (titleString.isEmpty() || dateString.isEmpty() || locString.isEmpty()) {
                    Toast.makeText(VaccinationRecord.this, R.string.toast_empty_fields,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VaccinationRecord.this, R.string.toast_sent, Toast.LENGTH_SHORT).show();
                    Vaccine f = new Vaccine(titleString, dateString, locString, email);
                    myRef.child("vacc_record").push().setValue(f);
                    finish();
                }

            }
        });


    }
}
