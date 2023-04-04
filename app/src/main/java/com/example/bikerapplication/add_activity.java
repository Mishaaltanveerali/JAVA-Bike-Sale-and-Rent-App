package com.example.bikerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_activity extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText color;
    Button btnAddData;

    DatabaseReference BikeDbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name_bike);
        price = findViewById(R.id.price_add);
        color = findViewById(R.id.colore_add);
        btnAddData = findViewById(R.id.addButton);

        BikeDbRef = FirebaseDatabase.getInstance().getReference().child("Bikes");

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBikeData();
            }
        });

    }
    private void addBikeData(){
        String n= name.getText().toString();
        String p= price.getText().toString();
        String c= color.getText().toString();


        BikeData bikedata = new BikeData(n,p,c);

        BikeDbRef.child(n).setValue(bikedata);
        Toast.makeText(add_activity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
    }
}