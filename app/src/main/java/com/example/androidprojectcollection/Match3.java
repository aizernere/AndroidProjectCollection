package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import android.os.Handler;

public class Match3 extends AppCompatActivity {
    private Button[] buttons;
    private int[] colors;
    private int[] colorPicker = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private Random random = new Random();
    Button reset;
    TextView lblScore;
    static int Score = 0;
    static boolean hasWon=false;
    boolean swapping = false;

    int index = 0;
    int toSwap = 0;
//    boolean isSuccess = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);
        lblScore = findViewById(R.id.lblScore);
        lblScore.setText(Integer.toString(Score));
        buttons = new Button[26];
        colors = new int[26];
        buttons[0] = findViewById(R.id.btn0);
        buttons[1] = findViewById(R.id.btn1);
        buttons[2] = findViewById(R.id.btn2);
        buttons[3] = findViewById(R.id.btn3);
        buttons[4] = findViewById(R.id.btn4);
        buttons[5] = findViewById(R.id.btn5);
        buttons[6] = findViewById(R.id.btn6);
        buttons[7] = findViewById(R.id.btn7);
        buttons[8] = findViewById(R.id.btn8);
        buttons[9] = findViewById(R.id.btn9);
        buttons[10] = findViewById(R.id.btn10);
        buttons[11] = findViewById(R.id.btn11);
        buttons[12] = findViewById(R.id.btn12);
        buttons[13] = findViewById(R.id.btn13);
        buttons[14] = findViewById(R.id.btn14);
        buttons[15] = findViewById(R.id.btn15);
        buttons[16] = findViewById(R.id.btn16);
        buttons[17] = findViewById(R.id.btn17);
        buttons[18] = findViewById(R.id.btn18);
        buttons[19] = findViewById(R.id.btn19);
        buttons[20] = findViewById(R.id.btn20);
        buttons[21] = findViewById(R.id.btn21);
        buttons[22] = findViewById(R.id.btn22);
        buttons[23] = findViewById(R.id.btn23);
        buttons[24] = findViewById(R.id.btn24);
        buttons[25] = findViewById(R.id.btn25);

        int i=0;
        for (Button button : buttons) {
            int color = getRandomColor();
            colors[i] = color;
            button.setBackgroundColor(color);
            i++;
        }
        checkBoard();
        Score=0;
        lblScore.setText("Score: " + Score);

        for (i = 1; i <= 25; i++) {
            int click = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!swapping){
                        index = click;
                    }else{
                        toSwap = click;
                    }
                    if(!swapping){
                        try{
                            for(int j=1;j<=25;j++){
                                if(j==index-5||j==index-1||j==index+1||j==index+5){
                                    continue;
                                }
                                else if(j==index){
                                    buttons[j].setText("O");
                                }
                                else{
                                    buttons[j].setEnabled(false);
                                    buttons[j].setText("X");
                                }
                            }
                            swapping = true;
                        }
                        catch(IndexOutOfBoundsException e){

                        }
                    }else{
                        swapColors(index, toSwap);
                        swapping = false;
                        for(int j=1;j<=25;j++){
                            buttons[j].setEnabled(true);
                            buttons[j].setText("");
                        }
                        checkBoard();
//                        if(isSuccess){
//                            //do nothing;
//                            isSuccess = false;
//                        }else{
//                            swapColors(index, toSwap);
//                        }
                    }



                }
            });
        }
        reset=findViewById(R.id.btnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasWon = false;
                int i=0;
                for (Button button : buttons) {
                    int color = getRandomColor();
                    colors[i] = color;
                    button.setBackgroundColor(color);
                    buttons[i].setEnabled(true);
                    buttons[i].setText("");
                    i++;
                }
                checkBoard();
                Score = 0;
                lblScore.setText("Score: " + Score);
            }
        });
    }

    private void swapColors(int index, int toSwap) {
        int temp = colors[toSwap];
        colors[toSwap] = colors[index];
        buttons[toSwap].setBackgroundColor(colors[index]);
        colors[index] = temp;
        buttons[index].setBackgroundColor(temp);
    }


    private Handler handler = new Handler();
    private void checkBoard() {
        boolean firstLine1 = colors[1]==colors[2]&&colors[2]==colors[3];
        boolean firstLine2 = colors[2]==colors[3]&&colors[3]==colors[4];
        boolean firstLine3 = colors[3]==colors[4]&&colors[4]==colors[5];
        boolean secondLine1 = colors[6]==colors[7]&&colors[7]==colors[8];
        boolean secondLine2 = colors[7]==colors[8]&&colors[8]==colors[9];
        boolean secondLine3 = colors[8]==colors[9]&&colors[9]==colors[10];
        boolean thirdLine1 = colors[11]==colors[12]&&colors[12]==colors[13];
        boolean thirdLine2 = colors[12]==colors[13]&&colors[13]==colors[14];
        boolean thirdLine3 = colors[13]==colors[14]&&colors[14]==colors[15];
        boolean fourthLine1 = colors[16]==colors[17]&&colors[17]==colors[18];
        boolean fourthLine2 = colors[17]==colors[18]&&colors[18]==colors[19];
        boolean fourthLine3 = colors[18]==colors[19]&&colors[19]==colors[20];
        boolean fifthLine1 = colors[21]==colors[22]&&colors[22]==colors[23];
        boolean fifthLine2 = colors[22]==colors[23]&&colors[23]==colors[24];
        boolean fifthLine3 = colors[23]==colors[24]&&colors[24]==colors[25];
        boolean firstLine1V = colors[1]==colors[6]&&colors[6]==colors[11];
        boolean firstLine2V = colors[6]==colors[11]&&colors[11]==colors[16];
        boolean firstLine3V = colors[11]==colors[16]&&colors[16]==colors[21];
        boolean secondLine1V = colors[2]==colors[7]&&colors[7]==colors[12];
        boolean secondLine2V = colors[7]==colors[12]&&colors[12]==colors[17];
        boolean secondLine3V = colors[12]==colors[17]&&colors[17]==colors[22];
        boolean thirdLine1V = colors[3]==colors[8]&&colors[8]==colors[13];
        boolean thirdLine2V = colors[8]==colors[13]&&colors[13]==colors[18];
        boolean thirdLine3V = colors[13]==colors[18]&&colors[18]==colors[23];
        boolean fourthLine1V = colors[4]==colors[9]&&colors[9]==colors[14];
        boolean fourthLine2V = colors[9]==colors[14]&&colors[14]==colors[19];
        boolean fourthLine3V = colors[14]==colors[19]&&colors[19]==colors[24];
        boolean fifthLine1V = colors[5]==colors[10]&&colors[10]==colors[15];
        boolean fifthLine2V = colors[10]==colors[15]&&colors[15]==colors[20];
        boolean fifthLine3V = colors[15]==colors[20]&&colors[20]==colors[25];
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if((firstLine1||firstLine2||firstLine3||secondLine1||secondLine2||secondLine3||thirdLine1||thirdLine2||thirdLine3||fourthLine1||fourthLine2||fourthLine3||fifthLine1||fifthLine2||fifthLine3)&&!hasWon){
                    Score++;
                    lblScore.setText("Score: " + Score);
//            isSuccess=true;
                    for (int i = 1; i <= 25; i++) {
                        if ((colors[i] == colors[i + 1] && colors[i + 1] == colors[i + 2])&&i%5!=0&&i!=4&&i!=9&&i!=14&&i!=19&&i!=24) {
                            for (int j = i; j <= i + 2; j++) {
                                int color = getRandomColor();
                                colors[j] = color;
                                buttons[j].setBackgroundColor(color);
                            }
                            checkBoard();
                            break;
                        }
                    }
                }else if((firstLine1V||firstLine2V||firstLine3V||secondLine1V||secondLine2V||secondLine3V||thirdLine1V||thirdLine2V||thirdLine3V||fourthLine1V||fourthLine2V||fourthLine3V||fifthLine1V||fifthLine2V||fifthLine3V)&&!hasWon){
                    Score++;
                    lblScore.setText("Score: " + Score);
                    for (int i = 1; i <= 25; i++) {
                        if (colors[i] == colors[i + 5] && colors[i + 5] == colors[i + 10]) {
                            for (int j = i; j <= i + 10; j++) {
                                if(j==i||j==i+5||j==i+10){
                                    int color = getRandomColor();
                                    colors[j] = color;
                                    buttons[j].setBackgroundColor(color);
                                }
                            }
                            checkBoard();
                            break;
                        }
                    }
                }
            }
        }, 1000);
        if(Score==8){
            lblScore.setText("You won!");
            Score = 0;
            hasWon = true;
            for (Button button : buttons) {
                button.setEnabled(false);
            }
        }
    }

    private int getRandomColor() {
        return colorPicker[random.nextInt(colorPicker.length)];
    }
}
