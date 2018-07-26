package com.hackathon.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Nutrition extends AppCompatActivity {

    public static final int MONTH_1_3 = 0;
    public static final int MONTH_4 = 1;
    public static final int MONTH_5 = 2;
    public static final int MONTH_6 = 3;
    public static final int MONTH_7 = 4;
    public static final int MONTH_8 = 5;
    public static final int MONTH_9 = 6;
    public static final int VACCATION_GUIDE = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        Button btnmonth1_3 = findViewById(R.id.btn_month1_3);
        Button btnmonth4 = findViewById(R.id.btn_month4);
        Button btnmonth5 = findViewById(R.id.btn_month5);
        Button btnmonth6 = findViewById(R.id.btn_month6);
        Button btnmonth7 = findViewById(R.id.btn_month7);
        Button btnmonth8 = findViewById(R.id.btn_month8);
        Button btnmonth9 = findViewById(R.id.btn_month9);
        Button btnmonth10 = findViewById(R.id.vacc_guide_btn);


        btnmonth1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_1_3);
                startActivity(myIntent);
            }
        });

        btnmonth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_4);
                startActivity(myIntent);
            }
        });

        btnmonth5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_5);
                startActivity(myIntent);
            }
        });

        btnmonth6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_6);
                startActivity(myIntent);
            }
        });

        btnmonth7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_7);
                startActivity(myIntent);
            }
        });

        btnmonth8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_8);
                startActivity(myIntent);
            }
        });

        btnmonth9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , MONTH_9);
                startActivity(myIntent);
            }
        });

        btnmonth10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), ActivityGuidelines.class);
                myIntent.putExtra("Section" , VACCATION_GUIDE);
                startActivity(myIntent);
            }
        });


    }
}
