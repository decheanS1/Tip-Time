package com.example.tiptime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private EditText inputEditText;
    private TextView outputTextView;
    private RadioGroup radioGroup;

    private Button button;
    private double finalValue;
    private String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputEditText = findViewById(R.id.editValue);
        outputTextView = findViewById(R.id.textView3);
        radioGroup = findViewById(R.id.radioGroup);

        button = findViewById(R.id.convertBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = inputEditText.getText().toString();
                int amount = Integer.parseInt(value);
                int checkRadioId = radioGroup.getCheckedRadioButtonId();
                if (checkRadioId == R.id.mili) {
                    finalValue = amount * 0.033814;
                    unit = " fluid ounces";
                } else if (checkRadioId == R.id.ounce) {
                    finalValue = amount / 0.033814;
                    unit = " milliliters";
                } else if (checkRadioId == R.id.grams) {
                    finalValue = amount * 0.00422675;
                    unit = " cups";
                } else if (checkRadioId == R.id.cups) {
                    finalValue = amount / 0.00422675;
                    unit = " grams";
                }

                outputTextView.setText("" +String.format("%.2f", finalValue) + unit);


            }
        });


    }
}