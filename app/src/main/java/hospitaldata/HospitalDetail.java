package hospitaldata;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.projects.Hospital;
import com.hackathon.projects.R;

public class HospitalDetail extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HospitalDetail";
    TextView textViewName, textViewAddress, textViewPincode, textViewTelephone, textViewMobile,
            textViewEmergency, textViewAmbulance, textViewTollfree, textViewHelpLine, textViewEmail, textViewWebsite, textViewBads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_hospital_detail);

        Hospital hospital = (Hospital) getIntent().getSerializableExtra("object");

        textViewName = findViewById(R.id.details_name_textView);
        textViewName.setText(hospital.getName());

        textViewAddress = findViewById(R.id.details_address_textView);
        textViewAddress.setText(hospital.getAddress());

        textViewPincode = findViewById(R.id.details_pincode_textView);
        textViewPincode.setText(hospital.getPincode());

        textViewTelephone = findViewById(R.id.details_telephone_textView);
        textViewTelephone.setText(hospital.getTelephone().split(",")[0]);

        textViewMobile = findViewById(R.id.details_mobile_textView);
        textViewMobile.setText(hospital.getMobilenumber().split(",")[0]);

        textViewEmergency = findViewById(R.id.details_emergency_textView);
        textViewEmergency.setText(hospital.getEmergencynum());

        textViewAmbulance = findViewById(R.id.details_ambulance_textView);
        textViewAmbulance.setText(hospital.getAmbulancenum());

        textViewTollfree = findViewById(R.id.details_tollfree_textView);
        textViewTollfree.setText(hospital.getTollfree());

        textViewHelpLine = findViewById(R.id.details_helpline_textView);
        textViewHelpLine.setText(hospital.getHelpline());

        textViewEmail = findViewById(R.id.details_email_textView);
        textViewEmail.setText(hospital.getPrimaryemail());

        textViewWebsite = findViewById(R.id.details_website_textView);
        textViewWebsite.setText(hospital.getWebsite());

        textViewBads = findViewById(R.id.details_numofbads_textView);
        textViewBads.setText(hospital.getTotalnumofbads());


        setclickEvents();
    }

    private void setclickEvents() {
        findViewById(R.id.btnName).setOnClickListener(this);
        findViewById(R.id.btnAddress).setOnClickListener(this);
        findViewById(R.id.btnPinCode).setOnClickListener(this);
        findViewById(R.id.btnTelephone).setOnClickListener(this);
        findViewById(R.id.btnMobile).setOnClickListener(this);
        findViewById(R.id.btnEmergencyNumber).setOnClickListener(this);
        findViewById(R.id.btnAmbulanceNumber).setOnClickListener(this);
        findViewById(R.id.btnTollFreeNumber).setOnClickListener(this);
        findViewById(R.id.btnHelplineNumber).setOnClickListener(this);
        findViewById(R.id.btnEmail).setOnClickListener(this);
        findViewById(R.id.btnWebsite).setOnClickListener(this);
        findViewById(R.id.btnTotalBads).setOnClickListener(this);
    }

    @Override
    public void onClick(View targetView) {
        if (targetView == findViewById(R.id.btnAddress)) {
            Log.d(TAG, "onClick: textViewAddress " + textViewAddress.getText().toString());
            String map = "http://maps.google.co.in/maps?q=" + textViewAddress.getText();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
            startActivity(intent);
        } else if (targetView == findViewById(R.id.btnTelephone)) {
            Log.d(TAG, "onClick: textViewTelephone " + textViewTelephone.getText().toString());
            if (!textViewTelephone.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewTelephone.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewTelephone.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnMobile)) {
            Log.d(TAG, "onClick: textViewMobile " + textViewMobile.getText().toString());
            if (!textViewMobile.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewMobile.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewMobile.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnEmergencyNumber)) {
            Log.d(TAG, "onClick: textViewEmergency " + textViewEmergency.getText().toString());
            if (!textViewEmergency.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewEmergency.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewEmergency.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnAmbulanceNumber)) {
            Log.d(TAG, "onClick: textViewAmbulance " + textViewAmbulance.getText().toString());
            if (!textViewAmbulance.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewAmbulance.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewAmbulance.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnTollFreeNumber)) {
            Log.d(TAG, "onClick: textViewTollfree " + textViewTollfree.getText().toString());
            if (!textViewTollfree.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewTollfree.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewTollfree.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnHelplineNumber)) {
            Log.d(TAG, "onClick: textViewHelpLine " + textViewHelpLine.getText().toString());
            if (!textViewHelpLine.getText().toString().contentEquals("NA") && !TextUtils.isEmpty(textViewHelpLine.getText().toString())) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewHelpLine.getText().toString()));
                if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnEmail)) {
            Log.d(TAG, "onClick: textViewEmail " + textViewEmail.getText().toString());
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{textViewEmail.getText().toString()});
            try {
                startActivity(Intent.createChooser(intent, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(HospitalDetail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        } else if (targetView == findViewById(R.id.btnWebsite)) {
            Log.d(TAG, "onClick: textViewWebsite " + textViewWebsite.getText().toString());
            String url = textViewWebsite.getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else {
            Toast.makeText(this, "DATA NOT AVAILABLE", Toast.LENGTH_SHORT).show();
        }
    }

    public void doActivity(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View targetView) {

                if (targetView == textViewAddress) {
                    Log.d(TAG, "onClick: textViewAddress " + textViewAddress.getText().toString());
                    String map = "http://maps.google.co.in/maps?q=" + textViewAddress.getText();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                    startActivity(intent);
                } else if (targetView == textViewTelephone
                        /**/ || targetView == textViewMobile
                        /**/ || targetView == textViewEmergency
                        /**/ || targetView == textViewAmbulance
                        /**/ || targetView == textViewTollfree
                        /**/ || targetView == textViewHelpLine) {
                    Log.d(TAG, "onClick: textViewTelephone " + textViewTelephone.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewTelephone.getText().toString().trim()));
                    if (ActivityCompat.checkSelfPermission(HospitalDetail.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent);
                } else if (targetView == textViewEmail) {
                    Log.d(TAG, "onClick: textViewEmail " + textViewEmail.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, textViewEmail.getText().toString());
                    try {
                        startActivity(Intent.createChooser(intent, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(HospitalDetail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                } else if (targetView == textViewWebsite) {
                    Log.d(TAG, "onClick: textViewWebsite " + textViewWebsite.getText().toString());
                    String url = textViewWebsite.getText().toString();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }/*  if (t.getText().equals("Address")) {
                    String map = "http://maps.google.co.in/maps?q=" + textViewAddress.getText();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                    startActivity(intent);
                } else if (t.getText().equals("Telephone")
                        *//**//* || t.getText().equals("Mobile")
                 *//**//* || t.getText().equals("Emergency No.")
                 *//**//* || t.getText().equals("Ambulance")
                 *//**//* || t.getText().equals("TollFree")
                 *//**//* || t.getText().equals("Helpline")) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + textViewTelephone.getText()));
                    startActivity(intent);
                } else if (t.getText().equals("Email")) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{textViewEmail.getText().toString()});
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(HospitalDetail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                } else if (t.getText().equals("Website")) {
                    String url = textViewWebsite.getText().toString();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }*/
            }
        });
    }


}
