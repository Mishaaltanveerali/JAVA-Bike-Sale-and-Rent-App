package com.example.bikerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_switch2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch2);

        Button AdminLoginButton = findViewById(R.id.admin_login_button);


        AdminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login screen
                Intent intent = new Intent(activity_switch2.this, activity_admin_login.class);
                startActivity(intent);
            }
        });
    }
}