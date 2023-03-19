package com.example.tiptime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private RadioGroup choices;
    private EditText cost;
    private Switch aSwitch;
    private double tipPercent;
    private TextView textView;
    private boolean isRoundTip;

    private double tipAmount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cost = findViewById(R.id.cost);
        calculate = findViewById(R.id.calculate);
        choices = findViewById(R.id.radioGroup);
        aSwitch = findViewById(R.id.switch1);
        textView = findViewById(R.id.tipAmount);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String costString = cost.getText().toString();
                int amount = Integer.parseInt(costString);
                int checkRadioId = choices.getCheckedRadioButtonId();
                if (checkRadioId == R.id.amazing){
                    tipPercent = 0.2;
                }
                if (checkRadioId == R.id.good){
                    tipPercent = 0.18;
                }
                if (checkRadioId == R.id.ok){
                    tipPercent = 0.15;
                }

                isRoundTip = aSwitch.isChecked();
                tipAmount = amount * tipPercent;

                if (isRoundTip){
                    tipAmount = Math.round(tipAmount);
                }
                textView.setText(""+tipAmount);


            }
        });





    }
}