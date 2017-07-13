package com.example.clicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numb;
    Button plusOne;
    Button reset;
    int n = 0;
    public void actionPlus (int n){
        this.n = n + 1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numb = (TextView) findViewById(R.id.numb);
        plusOne = (Button) findViewById(R.id.plusOne);
        reset = (Button) findViewById(R.id.reset);


        View.OnClickListener oclPlusOne = new View.OnClickListener() {
            public void onClick(View v) {
                actionPlus(n);
                if (n == 50) {
                    numb.setTextColor(Color.parseColor("#8B0000"));
                }
                if (n == 100) {
                    numb.setTextColor(Color.parseColor("#FF4500"));
                }
                String l = "" + n;
                numb.setText(l);
            }
        };
        plusOne.setOnClickListener(oclPlusOne);

        View.OnClickListener oclReset = new View.OnClickListener() {
            public void onClick(View v) {
                n = 0;
                numb.setText("Всё сначала!!");

            }
        };
        reset.setOnClickListener(oclReset);
    }
    }

