package com.example.viewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView myTexView = (TextView) findViewById(R.id.myText);
        myTexView.setText("New text in TextView");
        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setText("My Button");
        myBtn.setEnabled(false);
        CheckBox myChb = (CheckBox) findViewById(R.id.myChb);
        CheckBox myChb2 = (CheckBox) findViewById(R.id.myChb2);
        myChb.setChecked(true);
        myChb2.setChecked(false);
    }
}
