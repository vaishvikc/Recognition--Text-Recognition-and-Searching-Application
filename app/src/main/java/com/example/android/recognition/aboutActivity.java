package com.example.android.recognition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {
    TextView aboutTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutTv=(TextView)findViewById(R.id.tv_about);
        aboutTv.append("RECOGNITION\n\n\n");
        aboutTv.append("Version: 1.0\n\n\n");
        aboutTv.append("Developers:\n");
        aboutTv.append("Avadhoot Bangal\n");
        aboutTv.append("Vaishnavi Bhosale\n");
        aboutTv.append("Vaishvik Chaudhari\n");
    }
}
