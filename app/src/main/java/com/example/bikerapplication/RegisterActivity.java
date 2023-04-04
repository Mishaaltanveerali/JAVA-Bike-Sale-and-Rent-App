package com.example.bikerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

            private EditText etUsername;
            private EditText etEmail;
            private EditText etPassword;
            private Button btnRegister;

            DatabaseReference userDbRef;
            FirebaseAuth mAuth;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register);

                etUsername = findViewById(R.id.et_username);
                etEmail = findViewById(R.id.et_email);
                etPassword = findViewById(R.id.et_password);
                btnRegister = findViewById(R.id.btn_register);


                userDbRef = FirebaseDatabase.getInstance().getReference("User");

                mAuth = FirebaseAuth.getInstance();

                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        createUser();
                        //insertUserData();
                        // Validate the registration information
                        // If the information is valid, create a new account for the user
                        // If the information is invalid, display an error message
                    }
                });
            }
            /*private void insertUserData(){

                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(username,email,password);

                userDbRef.push().setValue(user);
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            }*/
            private void createUser(){
                String userName = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (TextUtils.isEmpty(userName)){
                    etUsername.setError("User Name cannot be empty");
                    etUsername.requestFocus();
                }else if(TextUtils.isEmpty(email)) {
                    etEmail.setError("E-mail cannot be empty");
                    etEmail.requestFocus();
                }else if(TextUtils.isEmpty(password)) {
                    etPassword.setError("Password cannot be empty");
                    etPassword.requestFocus();
                }else{
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User user = new User(userName,email,password);
                                //userDbRef.push().setValue(user);
                                FirebaseDatabase.getInstance().getReference("User")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(RegisterActivity.this,UserLoginActivity.class));
                                            }
                                        });
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        }