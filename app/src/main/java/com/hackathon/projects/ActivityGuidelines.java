package com.hackathon.projects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hackathon.projects.R;

import static com.hackathon.projects.Nutrition.MONTH_1_3;
import static com.hackathon.projects.Nutrition.MONTH_4;
import static com.hackathon.projects.Nutrition.MONTH_5;
import static com.hackathon.projects.Nutrition.MONTH_6;
import static com.hackathon.projects.Nutrition.MONTH_7;
import static com.hackathon.projects.Nutrition.MONTH_8;
import static com.hackathon.projects.Nutrition.MONTH_9;
import static com.hackathon.projects.Nutrition.VACCATION_GUIDE;

public class ActivityGuidelines extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int Section = getIntent().getIntExtra("Section", 0);
        switch (Section) {
            case MONTH_1_3:
                setContentView(R.layout.activity_month1_3);
                break;
            case MONTH_4:
                setContentView(R.layout.activity_month4);
                break;
            case MONTH_5:
                setContentView(R.layout.activity_month5);
                break;
            case MONTH_6:
                setContentView(R.layout.activity_month6);
                break;
            case MONTH_7:
                setContentView(R.layout.activity_month7);
                break;
            case MONTH_8:
                setContentView(R.layout.activity_month8);
                break;
            case MONTH_9:
                setContentView(R.layout.activity_month9);
                break;
            case VACCATION_GUIDE:
                setContentView(R.layout.activity_vacc_guide);
                break;
            default:
                break;
        }
    }
}
