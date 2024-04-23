package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tFname, tLname, tGender, tBdate, tPnum, tEmail, tAddress, tPostal, tHobby, tActive, tYear;
    Button Return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        tFname = findViewById(R.id.txtFname);
        tLname = findViewById(R.id.txtLname);
        tGender = findViewById(R.id.txtGender);
        tBdate = findViewById(R.id.txtBdate);
        tPnum = findViewById(R.id.txtPhone);
        tEmail = findViewById(R.id.txtEmail);
        tAddress = findViewById(R.id.txtAddress);
        tPostal = findViewById(R.id.txtPostal);
        tHobby = findViewById(R.id.txtHobby);
        tActive = findViewById(R.id.txtActive);
        tYear = findViewById(R.id.txtYear);
        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bdate = intent.getStringExtra("bdate_key");
        String phone = intent.getStringExtra("pnum_key");
        String email = intent.getStringExtra("eadd_key");
        String address = intent.getStringExtra("add_key");
        String postal = intent.getStringExtra("postal_key");
        String hobby = intent.getStringExtra("hobbies_key");
        String isActive = intent.getStringExtra("isActive_key");
        String year = intent.getStringExtra("yrlvl_key");
        tFname.setText(fname);
        tLname.setText(lname);
        tGender.setText(gender);
        tBdate.setText(bdate);
        tPnum.setText(phone);
        tEmail.setText(email);
        tAddress.setText(address);
        tPostal.setText(postal);
        tHobby.setText(hobby);
        tActive.setText(isActive);
        tYear.setText(year);
        Return = findViewById(R.id.btnReturn);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}