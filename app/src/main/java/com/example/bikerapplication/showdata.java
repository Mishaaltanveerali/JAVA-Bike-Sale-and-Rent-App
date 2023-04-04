package com.example.bikerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showdata extends AppCompatActivity {
    RecyclerView bikeListView;
    BikeListAdapter bikeListAdapter;
    ArrayList<Bike> list;
    DatabaseReference databaseReference;
    ArrayList<Bike> bikeList;

    //DatabaseReference bikeDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        bikeListView = findViewById(R.id.showdata_recekel_view);
        databaseReference=FirebaseDatabase.getInstance().getReference("Bikes");
        bikeListView.setHasFixedSize(true);
        bikeListView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        bikeListAdapter=new BikeListAdapter(this,list);
        bikeListView.setAdapter(bikeListAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot db:snapshot.getChildren()){
                    Bike bike=db.getValue(Bike.class);
                    list.add(bike);
                }
                bikeListAdapter.notifyDataSetChanged();
                Toast.makeText(showdata.this, "Successful", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}