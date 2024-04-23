package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLayout;
    Button btnExercise;
    Button btnCalculator;
    Button btnGame,btnGame2,btnPassing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLayout = (Button)findViewById(R.id.btnLayoutExercise);
        btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        MainActivity.this,//this activity
                        LayoutExercise.class);//destination activity
                startActivity(intent1);
            }
        });
        btnExercise = (Button)findViewById(R.id.btnButtonExercise);
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        MainActivity.this,//this activity
                        ButtonExercise.class);//destination activity
                startActivity(intent2);
            }
        });
        btnCalculator = (Button)findViewById(R.id.btnCalc);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        MainActivity.this,//this activity
                        CalculatorExercise.class);//destination activity
                startActivity(intent1);
            }
        });
        btnGame = findViewById(R.id.btnGame);
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Batch2.class);
                Toast.makeText(MainActivity.this, "Kaye Aizerner Evangelista - TicTacToe", Toast.LENGTH_SHORT).show();
                startActivity(intent3);
            }
        });
        btnGame2 = findViewById(R.id.btnGame2);
        btnGame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Match3.class);
                Toast.makeText(MainActivity.this, "Kaye Aizerner Evangelista - Match 3", Toast.LENGTH_SHORT).show();
                startActivity(intent3);
            }
        });
        btnPassing = findViewById(R.id.btnPassing);
        btnPassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PassingIntentsExercise.class);
                startActivity(intent);
            }
        });

    }
}