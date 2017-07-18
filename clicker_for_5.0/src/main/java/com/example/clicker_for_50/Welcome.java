package com.example.clicker_for_50;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button btnActTwo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnActTwo = (Button) findViewById(R.id.btnActTwo);

        View.OnClickListener oncBtn = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnActTwo:
                        Intent intent = new Intent(Welcome.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };
        btnActTwo.setOnClickListener(oncBtn);
    }
}
