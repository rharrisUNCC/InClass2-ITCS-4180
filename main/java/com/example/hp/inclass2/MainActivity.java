/*
In Class Assignment 2
MainActivity.java
Ryan Harris
 */
package com.example.hp.inclass2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsd;
    TextView result;
    double usdDouble;
    double euroDouble;
    double cadDouble;
    String usdValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Currency Converter");

        editTextUsd = findViewById(R.id.editTextUSD);
        result = findViewById(R.id.textViewResult);
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Button euroConversion = findViewById(R.id.button_euro);
        euroConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Demo", "Euro conversion button clicked!");
                usdValue = editTextUsd.getText().toString();
                if(usdValue.matches("")){
                    Toast.makeText(MainActivity.this, "Invalid input: Must fill field!", Toast.LENGTH_SHORT).show();
                }else if (usdValue.matches("[a-zA-Z_]+")){
                    Toast.makeText(MainActivity.this, "Invalid input: Numbers only!", Toast.LENGTH_SHORT).show();
                }else {
                    usdDouble = Double.parseDouble(usdValue);
                    euroDouble = usdDouble * 0.87;
                    result.setText(decimalFormat.format(euroDouble));
                }
            }
        });


        Button cadConversion = findViewById(R.id.button_cad);
        cadConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Demo", "CAD conversion button clicked!");
                usdValue = editTextUsd.getText().toString();
                if (usdValue.matches("")) {
                    Toast.makeText(MainActivity.this, "Invalid input: Must fill field!", Toast.LENGTH_SHORT).show();
                } else if (usdValue.matches("[a-zA-Z_]+")){
                    Toast.makeText(MainActivity.this, "Invalid input: Numbers only!", Toast.LENGTH_SHORT).show();
                } else {
                    usdValue = editTextUsd.getText().toString();
                    usdDouble = Double.parseDouble(usdValue);
                    cadDouble = usdDouble * 1.30;
                    result.setText(decimalFormat.format(cadDouble));
                }
            }
        });

        Button clearText = findViewById(R.id.button_clear);
        clearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Demo", "Clear button clicked!");
                editTextUsd.setText("");
                result.setText("");
            }
        });
    }
}
