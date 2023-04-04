package com.example.bikerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_manager extends AppCompatActivity implements View.OnClickListener {

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Button btnAdd;
        Button btnView;
        Button btnEdit;
        Button btnDelete;
        Button btnPost;

        btnAdd = findViewById(R.id.btn_add);
        btnView = findViewById(R.id.btn_view);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);
        btnPost = findViewById(R.id.btn_post);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        username = getIntent().getStringExtra("username");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                // Open the activity for buying a bike
                Intent intent1 = new Intent(activity_manager.this, add_activity.class);
                startActivity(intent1);
                break;
            case R.id.btn_view:
                //Open the activity for buying bike parts

               Intent intent2 = new Intent(activity_manager.this, showdata.class);
                startActivity(intent2);
                break;
            case R.id.btn_edit:
                 //Open the activity for renting a bike
                Intent intent3 = new Intent(activity_manager.this, activity_edit.class);
                startActivity(intent3);
                break;
            //case R.id.btn_delete:
                // Open the activity for renting a bike
               // Intent intent4 = new Intent(activity_manager.this, activity_delete.class);
                //startActivity(intent4);
                //break;
           // case R.id.btn_post:
                // Open the activity for renting a bike
             //   Intent intent5 = new Intent(activity_manager.this, showdata.class);
               // startActivity(intent5);
                //break;
        }
    }
}