package com.example.bikerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class activity_admin_login extends AppCompatActivity {

    EditText adminEmail;
    EditText adminPassword;
    Button btnLogin;

    FirebaseAuth mAuth;
    FirebaseDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminEmail = findViewById(R.id.admin_email);
        adminPassword = findViewById(R.id.admin_password);
        btnLogin = findViewById(R.id.l_btn);

        mAuth = FirebaseAuth.getInstance();

        //btnLogin.setOnClickListener(this::onClick);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAdmin();
                //String username = AdminName.getText().toString();
                //if (validateCredentials()) {
                //Intent intent = new Intent(activity_admin_login.this, activity_manager.class);
                //startActivity(intent);
                //intent.putExtra("username", username);
                //} else {
                //showErrorMessage();
                //}
            }
        });
    }
    private void loginAdmin(){
        String email = adminEmail.getText().toString();
        String password = adminPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            adminEmail.setError("User Name cannot be empty");
            adminEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)) {
            adminPassword.setError("Password cannot be empty");
            adminPassword.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(activity_admin_login.this, "Admin Logged In Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(activity_admin_login.this, activity_manager.class));
                    } else {
                        Toast.makeText(activity_admin_login.this, "Login Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}