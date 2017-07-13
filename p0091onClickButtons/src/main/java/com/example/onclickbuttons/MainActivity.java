package com.example.onclickbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    TextView numbPlus;
    Button btnOk;
    Button btnCancel;
    Button plusOne;
    int numberForPlus = 0;
    public void plusForPlus(int numberForPlus){
        this.numberForPlus = numberForPlus +1;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tvOut = (TextView) findViewById(R.id.tvOut);
         numbPlus = (TextView) findViewById(R.id.numbPlus);
         btnOk = (Button) findViewById(R.id.btnOk);
         btnCancel = (Button) findViewById(R.id.btnCancel);
         plusOne = (Button) findViewById(R.id.plusOne);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tvOut.setText("Нажата кнопка ОК");
            }
        };
        btnOk.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)
                tvOut.setText("Нажата кнопка Cancel");
            }
        };
        btnCancel.setOnClickListener(oclBtnCancel);



        View.OnClickListener oclBtnPlus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)
                plusForPlus(numberForPlus);
                String l = "" + numberForPlus;
                numbPlus.setText(l);
            }
        };
        plusOne.setOnClickListener(oclBtnPlus);

    }
}
