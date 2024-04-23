package com.example.androidprojectcollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonExercise extends AppCompatActivity {
    Button btnClose;
    Button btnToast;
    Button btnBG;
    Button btnBGBtn;
    Button btnDisappear;
    boolean darkMode = false;
    boolean buttonColor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        btnClose = (Button)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        ButtonExercise.this,//this activity
                        EmptyActivity.class);//destination activity
                startActivity(intent1);
            }
        });

        btnToast= (Button)findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Do you find yourself attractive, huh?", Toast.LENGTH_SHORT).show();
            }
        });

        btnBG= (Button)findViewById(R.id.btnBG);
        btnBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View window = getWindow().getDecorView();
                if(!darkMode){
                    window.setBackgroundColor(Color.DKGRAY);
                    darkMode = true;
                }else{
                    window.setBackgroundColor(Color.WHITE);
                    darkMode = false;
                }

            }
        });

        btnBGBtn= (Button)findViewById(R.id.btnBGBtn);
        btnBGBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!buttonColor){
                    view.setBackgroundColor(Color.WHITE);
                    btnBGBtn.setTextColor(Color.BLACK);
                    buttonColor = true;
                }else{
                    view.setBackgroundColor(0xFF6200EE);
                    btnBGBtn.setTextColor(Color.WHITE);
                    buttonColor = false;
                }

            }
        });

        btnDisappear = (Button)findViewById(R.id.btnDisappear);
        btnDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDisappear.setVisibility(View.INVISIBLE);
            }
        });
    }

}
