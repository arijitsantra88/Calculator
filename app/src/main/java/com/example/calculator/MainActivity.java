package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int mode = 0;
    EditText f1,f2;
    TextView res;
    Button mMod,mCal;
    double ans;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = findViewById(R.id.field1);
        f2 = findViewById(R.id.field2);
        res = findViewById(R.id.resultshow);
        mMod = findViewById(R.id.button);
        mCal = findViewById(R.id.button2);
    }
    public void onMode(View view){
        mode++;
        mode = mode%4;
        switch(mode){
            case 0: mMod.setText("MODE ADDITION");
                break;
            case 1: mMod.setText("MODE SUBTRACTION");
                break;
            case 2: mMod.setText("MODE MULTIPLICATION");
                break;
            case 3: mMod.setText("MODE DIVISION");
                break;

        }

    }
    public void onCalculate(View view){
        String s1,s2;
        s1 = f1.getText().toString().trim();
        s2 = f2.getText().toString().trim();
        if(s1.length()==0||s2.length()==0){
            Toast.makeText(this, "FIELD EMPTY", Toast.LENGTH_LONG).show();
            res.setText(String.valueOf(" "));
            return;
        }
        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        switch(mode){
            case 0: ans = n1 + n2;
                break;
            case 1: ans = n1 - n2;
                break;
            case 2: ans = n1 * n2;
                break;
            case 3: ans = n1 / n2;
                break;

        }
        res.setText(String.valueOf(ans));
    }
}