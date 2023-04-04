package com.example.bikerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button UserButton = findViewById(R.id.user_button);
        Button AdminButton = findViewById(R.id.admin_button);
        mAuth = FirebaseAuth.getInstance();

        UserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FirebaseUser user = mAuth.getCurrentUser();
                if(user == null){
                    startActivity(new Intent(MainActivity.this,activity_switch.class));
                }*/
                // Navigate to the register screen
                Intent intent = new Intent(MainActivity.this, activity_switch.class);
                startActivity(intent);
            }
        });

        AdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FirebaseUser Admin = mAuth.getCurrentUser();
                if(Admin == null){
                    startActivity(new Intent(MainActivity.this,activity_switch2.class));
                }*/
                // Navigate to the login screen
                Intent intent = new Intent(MainActivity.this, activity_switch2.class);
                startActivity(intent);
            }
        });

    }

    /*@Override
    protected void onStart(){
        super.onStart();
    }*/
}