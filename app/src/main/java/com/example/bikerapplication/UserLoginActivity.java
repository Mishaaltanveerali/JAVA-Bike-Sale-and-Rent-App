package com.example.bikerapplication;

import static com.example.bikerapplication.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login2);

        etEmail = findViewById(id.et_email);
        etPassword = findViewById(id.et_password);
        btnLogin = findViewById(id.btn_login);

        mAuth = FirebaseAuth.getInstance();

        //btnLogin.setOnClickListener(this::onClick);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
                //String username = etUsername.getText().toString();
                //if (validateCredentials()) {
                //Intent intent = new Intent(UserLoginActivity.this, activity_dashboard.class);
                //intent.putExtra("username", username);
                //startActivity(intent);
                //} else {
                //showErrorMessage();
                //}
            }
        });

    }
    private void loginUser(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etEmail.setError("User Name cannot be empty");
            etEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)) {
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(UserLoginActivity.this, "User Logged In Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UserLoginActivity.this,activity_dashboard.class));
                    }else{
                        Toast.makeText(UserLoginActivity.this, "Login Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}