package com.example.clicker_for_50;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView numb;
    Button plusOne;
    Button reset;
    int n = 0;
    Toast toast;
    Toast toastSize;
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

        View.OnClickListener oclBtn = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.plusOne:
                        actionPlus(n);
                        if (n == 50) {
                            numb.setTextColor(Color.parseColor("#8B0000"));
                            toast =  Toast.makeText(getApplicationContext(), "ПОЛТИШОК!!!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        if (n == 100) {
                            numb.setTextColor(Color.parseColor("#FF4500"));
                            toast =  Toast.makeText(getApplicationContext(), "СОТОЧКА!!!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        if (n == 233) {
                            toast =  Toast.makeText(getApplicationContext(), "СКОРО!!!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        if (n == 437) {
                            toast =  Toast.makeText(getApplicationContext(), "ЛОЛ КЕК ЧЕБУРЕК!!!", Toast.LENGTH_SHORT);
                            LinearLayout toastContainer = (LinearLayout) toast.getView();
                            ImageView catImageView = new ImageView(getApplicationContext());
                            catImageView.setImageResource(R.drawable.trollface);
                            toastContainer.addView(catImageView, 0);
                            toast.show();
                        }
                        String l = "" + n;
                        numb.setText(l);
                        break;
                    case R.id.reset:
                        n = 0;
                        numb.setTextColor(Color.parseColor("#000000"));
                        numb.setText("Всё сначала!!");
                        break;
                }
            }
        };

        registerForContextMenu(numb);
        plusOne.setOnClickListener(oclBtn);
        reset.setOnClickListener(oclBtn);


    }

    final int MENU_SIZE_20 = 4;
    final int MENU_SIZE_40 = 5;
    final int MENU_SIZE_60 = 6;

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.numb:
                menu.add(0, MENU_SIZE_20, 0, "20");
                menu.add(0, MENU_SIZE_40, 0, "40");
                menu.add(0, MENU_SIZE_60, 0, "60");
                break;
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_SIZE_20:
                numb.setTextSize(20);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 20", Toast.LENGTH_SHORT);
                break;
            case MENU_SIZE_40:
                numb.setTextSize(40);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 40", Toast.LENGTH_SHORT);
                break;
            case MENU_SIZE_60:
                numb.setTextSize(60);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 60", Toast.LENGTH_SHORT);
                break;
        }
        return super.onContextItemSelected(item);
    }

}