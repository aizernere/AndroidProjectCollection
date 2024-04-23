package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class PassingIntentsExercise extends AppCompatActivity {
    Button btnSubmit;
    EditText fname, lname, bday, phoneNum, email, homeAdd, postalCode, hobby;
    RadioButton Male, Female, Others;
    Switch YesNo;
    Spinner year;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        btnSubmit = findViewById(R.id.btnSubmit);
        fname = findViewById(R.id.editTextFirst);
        lname = findViewById(R.id.editTextLast);
        Male = findViewById(R.id.rbMale);
        Female = findViewById(R.id.rbFemale);
        Others = findViewById(R.id.rbOthers);
        bday = findViewById(R.id.editTextBirthDate);
        phoneNum = findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextEmail);
        homeAdd = findViewById(R.id.editTextAddress);
        postalCode = findViewById(R.id.editTextPostal);
        hobby = findViewById(R.id.editTextHobby);
        YesNo = findViewById(R.id.switchStudy);
        year = findViewById(R.id.yearlvl);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fName = fname.getText().toString();
                String lName = lname.getText().toString();
                String gender;
                if(Male.isChecked()){
                    gender = "Male";
                }else if(Female.isChecked()){
                    gender = "Female";
                }else if(Others.isChecked()){
                    gender = "Others";
                }else{
                    gender = "Unknown";
                }
                String bdate = bday.getText().toString();
                String phone = phoneNum.getText().toString();
                String emailAdd = email.getText().toString();
                String address = homeAdd.getText().toString();
                String postal = postalCode.getText().toString();
                String hobbies = hobby.getText().toString();
                String studying;
                String yearLevel;

                if(YesNo.isChecked()){
                    studying = "Active";
                }else{
                    studying = "Inactive";
                }
                if(year.getSelectedItem().toString().equals("1")){
                    yearLevel = "First Year";
                }else if(year.getSelectedItem().toString().equals("2")){
                    yearLevel = "Second Year";
                }
                else if(year.getSelectedItem().toString().equals("3")){
                    yearLevel = "Third Year";
                }
                else if(year.getSelectedItem().toString().equals("4")){
                    yearLevel = "Fourth Year";
                }
                else{
                    yearLevel = "Fifth Year";
                }
                if(fName.isEmpty()||lName.isEmpty()||bdate.isEmpty()||phone.isEmpty()||emailAdd.isEmpty()||address.isEmpty()||postal.isEmpty()){
                    Toast.makeText(PassingIntentsExercise.this, "Please make sure all fields are filled.", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                    intent.putExtra("fname_key",fName);
                    intent.putExtra("lname_key",lName);
                    intent.putExtra("gender_key",gender);
                    intent.putExtra("bdate_key",bdate);
                    intent.putExtra("pnum_key",phone);
                    intent.putExtra("eadd_key",emailAdd);
                    intent.putExtra("add_key",address);
                    intent.putExtra("postal_key",postal);
                    intent.putExtra("hobbies_key",hobbies);
                    intent.putExtra("isActive_key",studying);
                    intent.putExtra("yrlvl_key",yearLevel);
                    startActivity(intent);
                }

            }
        });
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname.setText("");
                lname.setText("");
                Male.setChecked(false);
                Female.setChecked(false);
                Others.setChecked(false);
                bday.setText("");
                phoneNum.setText("");
                email.setText("");
                homeAdd.setText("");
                postalCode.setText("");
                hobby.setText("");
                YesNo.setChecked(false);
                year.setSelection(0);
            }
        });
    }
}
