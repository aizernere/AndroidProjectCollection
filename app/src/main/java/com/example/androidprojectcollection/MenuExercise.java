package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnChanger = findViewById(R.id.btnTransformingButton);
        btnChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuExercise.this, "Your button is working.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.mItemChange:
                Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mItemTextSize:
                Toast.makeText(this, "Text Size is changed.", Toast.LENGTH_SHORT).show();
                btnChanger.setTextSize(7);
                break;
            case R.id.mItemTextColor:
                Toast.makeText(this, "Text Color is changed.", Toast.LENGTH_SHORT).show();
                btnChanger.setTextColor(Color.parseColor("#2e5467"));
                break;
            case R.id.mItemDisable:
                Toast.makeText(this, "Button is now disabled", Toast.LENGTH_SHORT).show();
                btnChanger.setEnabled(false);
                break;
            case R.id.mItemSquare:
                Toast.makeText(this, "Button is now squared.", Toast.LENGTH_SHORT).show();
                btnChanger.setBackground(getResources().getDrawable(R.drawable.squarebutton));
                break;
            case R.id.mItemBlue:
                Toast.makeText(this, "Button is now Light Blue.", Toast.LENGTH_SHORT).show();
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.lightBlue)));
                break;
            case R.id.mItemReset:
                Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
                btnChanger.setTextSize(20);
                btnChanger.setTextColor(Color.parseColor("#FFFFFF"));
                btnChanger.setEnabled(true);
                btnChanger.setBackground(getResources().getDrawable(R.drawable.roundbutton));
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.purple_500)));
                break;
            case R.id.mItemExit:
                Toast.makeText(this, "Exiting...", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }

        return true;
    }
}