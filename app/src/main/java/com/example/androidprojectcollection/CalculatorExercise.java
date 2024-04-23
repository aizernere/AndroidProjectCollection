package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {


    private TextView inputEquation;
    private TextView inputResult;
    private boolean hasOperations=false;
    private boolean hasDecimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        inputEquation = findViewById(R.id.input);
        inputResult = findViewById(R.id.output);
        findViewById(R.id.off).setOnClickListener(onClickListener);
        findViewById(R.id.btn0).setOnClickListener(onClickListener);
        findViewById(R.id.btn1).setOnClickListener(onClickListener);
        findViewById(R.id.btn2).setOnClickListener(onClickListener);
        findViewById(R.id.btn3).setOnClickListener(onClickListener);
        findViewById(R.id.btn4).setOnClickListener(onClickListener);
        findViewById(R.id.btn5).setOnClickListener(onClickListener);
        findViewById(R.id.btn6).setOnClickListener(onClickListener);
        findViewById(R.id.btn7).setOnClickListener(onClickListener);
        findViewById(R.id.btn8).setOnClickListener(onClickListener);
        findViewById(R.id.btn9).setOnClickListener(onClickListener);
        findViewById(R.id.btnPoint).setOnClickListener(onClickListener);
        findViewById(R.id.add).setOnClickListener(onClickListener);
        findViewById(R.id.subtract).setOnClickListener(onClickListener);
        findViewById(R.id.multiply).setOnClickListener(onClickListener);
        findViewById(R.id.divide).setOnClickListener(onClickListener);
        findViewById(R.id.clear).setOnClickListener(onClickListener);
        findViewById(R.id.equal).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String buttonText;
            String expression = inputEquation.getText().toString();
            if (v.getId() == R.id.equal) {
                if (expression.endsWith(".")) {
                    expression = expression.substring(0, expression.length() - 1);
                    inputEquation.setText(expression);
                    hasDecimal = false;
                }
                try{
                    evaluateExpression(expression);;
                }catch (Exception e){
                    inputResult.setText("Error");
                    Toast.makeText(CalculatorExercise.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }else if(v.getId() == R.id.off){
                finish();
            }else if(v.getId() == R.id.clear){
                inputEquation.setText("");
                inputResult.setText("");
                hasDecimal = false;
                hasOperations=false;
            }
            else if(v.getId() == R.id.btnPoint){
                if((inputEquation.getText().toString().equals("")||hasOperations)&&!hasDecimal){
                    inputEquation.append("0.");
                    hasDecimal=true;
                    hasOperations=false;
                    preEvaluate();
                }
                else if(!hasDecimal){
                    buttonText = ((MaterialButton) v).getText().toString();
                    inputEquation.append(buttonText);
                    hasDecimal = true;
                }else {
                    if (expression.endsWith(".")) {
                        expression = expression.substring(0, expression.length() - 1);
                        inputEquation.setText(expression);
                        hasDecimal = false;
                    }

                }
            }
            else if(v.getId() == R.id.add||v.getId() == R.id.subtract||v.getId() == R.id.divide||v.getId() == R.id.multiply){
                buttonText = ((MaterialButton) v).getText().toString();
                if(inputEquation.getText().toString().equals("")){

                }
                else if(!hasOperations){
                    if (expression.endsWith(".")) {
                        expression = expression.substring(0, expression.length() - 1);
                        inputEquation.setText(expression);
                    }
                    inputEquation.append(buttonText);
                    hasOperations = true;

                }else{
                    expression = expression.substring(0, expression.length() - 1);
                    inputEquation.setText(expression);
                    inputEquation.append(buttonText);
                }
                hasDecimal=false;
            }
            else{

                buttonText = ((MaterialButton) v).getText().toString();
                inputEquation.append(buttonText);
                hasOperations=false;
                try{
                    preEvaluate();
                }catch (Exception e){
                    inputResult.setText("Error");
                    Toast.makeText(CalculatorExercise.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }

    };

    private void evaluateExpression(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--;
                double num = Double.parseDouble(numBuilder.toString());
                operands.push(num);
            } else if (c == '+' || c == '-' || c == 'x' || c == '÷') {
                // next op
                while (!operators.isEmpty() && getPrecedence(c) <= getPrecedence(operators.peek())) {
                    double operand2 = operands.pop();
                    double operand1 = operands.pop();
                    char operator = operators.pop();
                    operands.push(applyOperation(operand1, operand2, operator));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double operand2 = operands.pop();
            double operand1 = operands.pop();
            char operator = operators.pop();
            operands.push(applyOperation(operand1, operand2, operator));
        }

        DecimalFormat format = new DecimalFormat("#.#######");
        inputResult.setText(format.format(operands.pop()));
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case 'x':
            case '÷':
                return 2;
            default:
                return -1; // Invalid operator
        }
    }

    private static double applyOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case 'x':
                return operand1 * operand2;
            case '÷':
                if (operand2 == 0) {
                    throw new ArithmeticException("Are you a higher being?");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private void preEvaluate() {
        String expression = inputEquation.getText().toString();

        String[] tokens = expression.split("(?=[+\\-x÷])|(?<=[+\\-x÷])");

        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];


            if (i + 1 < tokens.length) {
                double operand = Double.parseDouble(tokens[i + 1]);
                switch (operator) {
                    case "+":
                        result += operand;
                        break;
                    case "-":
                        result -= operand;
                        break;
                    case "x":
                        result *= operand;
                        break;
                    case "÷":
                            if (operand == 0) {
                                throw new ArithmeticException("Are you a higher being?");
                            }
                        result /= operand;
                        break;
                }
            } else {
                break;
            }
        }

        DecimalFormat format = new DecimalFormat("#.#######");
        inputResult.setText(format.format(result));

    }
}