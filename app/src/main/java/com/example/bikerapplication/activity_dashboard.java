package com.example.bikerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_dashboard extends AppCompatActivity implements View.OnClickListener{
    public activity_dashboard() {
    }

    String username;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnBuyBike;
        Button btnBuyBikeParts;
        Button btnRentBike;

        btnBuyBike = findViewById(R.id.btn_buy_bike);
        btnBuyBikeParts = findViewById(R.id.btn_buy_bike_parts);
        btnRentBike = findViewById(R.id.btn_rent_bike);

        btnBuyBike.setOnClickListener(this);
        btnBuyBikeParts.setOnClickListener(this);
        btnRentBike.setOnClickListener(this);
        username = getIntent().getStringExtra("username");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_buy_bike:
                // Open the activity for buying a bike
                Intent intent1 = new Intent(activity_dashboard.this, showdata.class);
                intent1.putExtra("username", username);
                startActivity(intent1);
                break;
            case R.id.btn_buy_bike_parts:
                // Open the activity for buying bike parts
                Intent intent2 = new Intent(activity_dashboard.this, activity_switch.class);
                intent2.putExtra("username", username);
                startActivity(intent2);
                break;
            //case R.id.btn_rent_bike:
                // Open the activity for renting a bike
              //  Intent intent3 = new Intent(activity_dashboard.this, showdata.class);
                //intent3.putExtra("username", username);
                //startActivity(intent3);
                //break;
        }
    }
}