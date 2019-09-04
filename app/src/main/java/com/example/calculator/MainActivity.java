package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;


public class MainActivity extends Activity implements View.OnClickListener {

    //объявляем кнопки и текстовое поле
    Button BtnOne, BtnTwo, BtnThree, BtnFour, BtnFive;
    Button BtnSix, BtnSeven, BtnEight, BtnNine, BtnZero;
    Button btPlus, btMinus, btMulti, btDiv, btEqual, btClear;
    TextView field;

    //объявляем переменные для вычислений
    int operand1, operand2, flagAction;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BtnOne = (Button) findViewById(R.id.BtnOne);
        BtnTwo = (Button) findViewById(R.id.BtnTwo);
        BtnThree = (Button) findViewById(R.id.BtnThree);
        BtnFour = (Button) findViewById(R.id.BtnFour);
        BtnFive = (Button) findViewById(R.id.BtnFive);
        BtnSix = (Button) findViewById(R.id.BtnSix);
        BtnSeven = (Button) findViewById(R.id.BtnSeven);
        BtnEight = (Button) findViewById(R.id.BtnEight);
        BtnNine = (Button) findViewById(R.id.BtnNine);
        BtnZero = (Button) findViewById(R.id.BtnZero);
        btPlus = (Button) findViewById(R.id.btPlus);
        btMinus = (Button) findViewById(R.id.btMinus);
        btMulti = (Button) findViewById(R.id.btMulti);
        btDiv = (Button) findViewById(R.id.btDiv);
        btEqual = (Button) findViewById(R.id.btEqual);
        btClear = (Button) findViewById(R.id.btClear);

        field = (TextView) findViewById(R.id.tvLCD);
        BtnOne.setOnClickListener(this);
        BtnTwo.setOnClickListener(this);
        BtnThree.setOnClickListener(this);
        BtnFour.setOnClickListener(this);
        BtnFive.setOnClickListener(this);
        BtnSix.setOnClickListener(this);
        BtnSeven.setOnClickListener(this);
        BtnEight.setOnClickListener(this);
        BtnNine.setOnClickListener(this);
        BtnZero.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMulti.setOnClickListener(this);
        btDiv.setOnClickListener(this);
        btClear.setOnClickListener(this);
        btEqual.setOnClickListener(this);

        //инициализируем переменные
        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;


        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;

        field.setText(Integer.toString(operand1));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btOne:
                ClickNumber(1);
                break;

            case R.id.btTwo:
                ClickNumber(2);
                break;

            case R.id.btThree:
                ClickNumber(3);
                break;

            case R.id.btFour:
                ClickNumber(4);
                break;

            case R.id.btFive:
                ClickNumber(5);
                break;

            case R.id.btSix:
                ClickNumber(6);
                break;

            case R.id.btSeven:
                ClickNumber(7);
                break;

            case R.id.btEight:
                ClickNumber(8);
                break;

            case R.id.btNine:
                ClickNumber(9);
                break;

            case R.id.btZero:
                ClickNumber(0);
                break;

            case R.id.btPlus:
                if (flagAction == 0) flagAction = 1;
                break;

            case R.id.btMinus:
                if (flagAction == 0) flagAction = 2;
                break;

            case R.id.btMulti:
                if (flagAction == 0) flagAction = 3;
                break;

            case R.id.btDiv:
                if (flagAction == 0) flagAction = 4;
                break;

            case R.id.btEqual:
                switch (flagAction) {

                    case 1:
                        result = operand1 + operand2;
                        break;

                    case 2:
                        result = operand1 - operand2;
                        break;

                    case 3:
                        result = operand1 * operand2;
                        break;

                    case 4:

                        result = (double) operand1 / (double) operand2;
                        break;

                    default:
                        Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG).show();

                }

                if (flagAction != 0) {
                    field.setText(Double.toString(result));
                    operand1 = 0;
                    operand2 = 0;
                    result = 0;
                    flagAction = 0;

                }
                break;

            case R.id.btClear:

                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                field.setText(Integer.toString(operand1));
                break;

        }

    }

    private void ClickNumber(int num) {

        if (flagAction == 0) {
            operand1 = operand1 * 10 + num;
            field.setText(Integer.toString(operand1));

        } else {
            operand2 = operand2 * 10 + num;
            field.setText(Integer.toString(operand2));

        }

    }

}



