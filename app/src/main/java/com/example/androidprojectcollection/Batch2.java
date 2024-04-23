package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Batch2 extends AppCompatActivity {

    static Button[][] button;
    Button reset;
    TextView lblTurn;
    GridLayout grid;
    static boolean isPlayerOne=true;
    static boolean hasWon=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch2);
        button = new Button[3][3];
        lblTurn = findViewById(R.id.lblTurn);
        reset = findViewById(R.id.btnReset);
        grid = findViewById(R.id.gridLayout);
        grid.setBackgroundColor(Color.RED);
        button[0][0] = findViewById(R.id.btn1);
        button[0][1] = findViewById(R.id.btn2);
        button[0][2] = findViewById(R.id.btn3);
        button[1][0] = findViewById(R.id.btn4);
        button[1][1] = findViewById(R.id.btn5);
        button[1][2] = findViewById(R.id.btn6);
        button[2][0] = findViewById(R.id.btn7);
        button[2][1] = findViewById(R.id.btn8);
        button[2][2] = findViewById(R.id.btn9);
        lblTurn.setText("Player O's Turn");
        button[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[0][0].setText("O");
                    button[0][0].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[0][0].setText("X");
                    button[0][0].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
            checkWin();
            }
        });
        button[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[0][1].setText("O");
                    button[0][1].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[0][1].setText("X");
                    button[0][1].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[0][2].setText("O");
                    button[0][2].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[0][2].setText("X");
                    button[0][2].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[1][0].setText("O");
                    button[1][0].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[1][0].setText("X");
                    button[1][0].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[1][1].setText("O");
                    button[1][1].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[1][1].setText("X");
                    button[1][1].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[1][2].setText("O");
                    button[1][2].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[1][2].setText("X");
                    button[1][2].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[2][0].setText("O");
                    button[2][0].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[2][0].setText("X");
                    button[2][0].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[2][1].setText("O");
                    button[2][1].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.RED);
                }else{
                    button[2][1].setText("X");
                    button[2][1].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        button[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayerOne){
                    button[2][2].setText("O");
                    button[2][2].setEnabled(false);
                    lblTurn.setText("Player X's Turn");
                    isPlayerOne = false;
                    grid.setBackgroundColor(Color.BLUE);
                }else{
                    button[2][2].setText("X");
                    button[2][2].setEnabled(false);
                    lblTurn.setText("Player O's Turn");
                    isPlayerOne = true;
                    grid.setBackgroundColor(Color.RED);
                }
                checkWin();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblTurn.setText("Player O's Turn");
                isPlayerOne = true;
                hasWon = false;
                int i=0;
                int j=0;
//                button[0][0].setEnabled(true);
//                button[0][0].setText("");
                for(i=0;i<3;i++){
                    for(j=0;j<3;j++){
                        button[i][j].setEnabled(true);
                        button[i][j].setText("");
                    }
                }
                grid.setBackgroundColor(Color.RED);
            }
        });

    }
    void checkWin(){
        //check 0
        boolean firstLine = button[0][0].getText().toString().equals("O")&&button[0][1].getText().toString().equals("O")&&button[0][2].getText().toString().equals("O");
        boolean secondLine = button[1][0].getText().toString().equals("O")&&button[1][1].getText().toString().equals("O")&&button[1][2].getText().toString().equals("O");
        boolean thirdLine = button[2][0].getText().toString().equals("O")&&button[2][1].getText().toString().equals("O")&&button[2][2].getText().toString().equals("O");
        boolean firstLineH = button[0][0].getText().toString().equals("O")&&button[1][0].getText().toString().equals("O")&&button[2][0].getText().toString().equals("O");
        boolean secondLineH = button[0][1].getText().toString().equals("O")&&button[1][1].getText().toString().equals("O")&&button[2][1].getText().toString().equals("O");
        boolean thirdLineH = button[0][2].getText().toString().equals("O")&&button[1][2].getText().toString().equals("O")&&button[2][2].getText().toString().equals("O");
        boolean diag1 = button[0][0].getText().toString().equals("O")&&button[1][1].getText().toString().equals("O")&&button[2][2].getText().toString().equals("O");
        boolean diag2 = button[0][2].getText().toString().equals("O")&&button[1][1].getText().toString().equals("O")&&button[2][0].getText().toString().equals("O");
        //check X
        boolean firstLineX = button[0][0].getText().toString().equals("X")&&button[0][1].getText().toString().equals("X")&&button[0][2].getText().toString().equals("X");
        boolean secondLineX = button[1][0].getText().toString().equals("X")&&button[1][1].getText().toString().equals("X")&&button[1][2].getText().toString().equals("X");
        boolean thirdLineX = button[2][0].getText().toString().equals("X")&&button[2][1].getText().toString().equals("X")&&button[2][2].getText().toString().equals("X");
        boolean firstLineHX = button[0][0].getText().toString().equals("X")&&button[1][0].getText().toString().equals("X")&&button[2][0].getText().toString().equals("X");
        boolean secondLineHX = button[0][1].getText().toString().equals("X")&&button[1][1].getText().toString().equals("X")&&button[2][1].getText().toString().equals("X");
        boolean thirdLineHX = button[0][2].getText().toString().equals("X")&&button[1][2].getText().toString().equals("X")&&button[2][2].getText().toString().equals("X");
        boolean diag1X = button[0][0].getText().toString().equals("X")&&button[1][1].getText().toString().equals("X")&&button[2][2].getText().toString().equals("X");
        boolean diag2X = button[0][2].getText().toString().equals("X")&&button[1][1].getText().toString().equals("X")&&button[2][0].getText().toString().equals("X");
        boolean testDraw =
                        !button[0][0].isEnabled()&&
                        !button[0][1].isEnabled()&&
                        !button[0][2].isEnabled()&&
                        !button[1][0].isEnabled()&&
                        !button[1][1].isEnabled()&&
                        !button[1][2].isEnabled()&&
                        !button[2][0].isEnabled()&&
                        !button[2][1].isEnabled()&&
                        !button[2][2].isEnabled();
        if(firstLine||secondLine||thirdLine||firstLineH||secondLineH||thirdLineH||diag1||diag2){
            Toast.makeText(this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            lblTurn.setText("Player O Wins!");
            hasWon = true;
            int i=0;
            int j=0;
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    button[i][j].setEnabled(false);

                }
            }
        }
        if(firstLineX||secondLineX||thirdLineX||firstLineHX||secondLineHX||thirdLineHX||diag1X||diag2X){
            Toast.makeText(this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            lblTurn.setText("Player O Wins!");
            hasWon=true;
            int i=0;
            int j=0;
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    button[i][j].setEnabled(false);
                }
            }
        }
        if(testDraw && !hasWon){
            Toast.makeText(this, "Draw! Play Again!", Toast.LENGTH_SHORT).show();
            lblTurn.setText("Draw!");
        }

    }
}