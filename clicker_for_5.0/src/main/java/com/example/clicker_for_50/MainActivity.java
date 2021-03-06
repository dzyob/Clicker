package com.example.clicker_for_50;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Начинаем описывать переменные
    TextView numb; //циферблат
    TextView welcome; //строчка приветствия
    Button plusOne; //кнопка плюсования +1
    Button reset; //кнопка сброса
    int n = 0; //переменная плюсования
    Toast toast; //сообщения ачивок
    Toast toastSize; //сообщения изменения размера шрифта для циферблата
    SeekBar polzunok; //ползунок изменения размера кнопки
    TextView commit; //подсказка для вызова контекстного меню
    TextView commitForMenu; //подсказка для меню
    ImageView cursorMenuImage; //картинка стрелки для меню
    ImageView cursorImg; //картинка стрелки для циферблата
    ConstraintLayout.LayoutParams sizetPlusOne; //переменная для передачи параметров кнопки

    //Метод плюсования - САМОЕ ГЛАВНОЕ В ЭТОМ НЕВЕРОЯТНОМ ПРИЛОЖЕНИИ
    public void actionPlus (int n){
        this.n = n + 1;
    }

    //Основные действия при нажатии клавишь
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        polzunok = (SeekBar) findViewById(R.id.polzunok);
        polzunok.setOnSeekBarChangeListener(polzunokAction);

        numb = (TextView) findViewById(R.id.numb);
        welcome = (TextView) findViewById(R.id.welcome);
        commit = (TextView) findViewById(R.id.commit);
        commitForMenu = (TextView) findViewById(R.id.commitForMenu);
        cursorMenuImage = (ImageView) findViewById(R.id.cursorMenuImage);
        cursorImg = (ImageView) findViewById(R.id.cursorImg);
        plusOne = (Button) findViewById(R.id.plusOne);
        reset = (Button) findViewById(R.id.reset);

        sizetPlusOne = (ConstraintLayout.LayoutParams) plusOne.getLayoutParams();

        //Вертим Анимацию
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
        welcome.startAnimation(anim);

        //Начинаем считать
        View.OnClickListener oclBtn = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.plusOne:
                        actionPlus(n);
                        if (n > 0) {
                            welcome.setVisibility(View.INVISIBLE);
                        }
                        switch (n) {
                            case 10:
                                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.transfernumb);
                                numb.startAnimation(anim);
                                break;
                            case 50:
                                numb.setTextColor(Color.parseColor("#8B0000"));
                                toast =  Toast.makeText(getApplicationContext(), "ПОЛТИШОК!!!", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case 100:
                                numb.setTextColor(Color.parseColor("#FF4500"));
                                toast =  Toast.makeText(getApplicationContext(), "СОТОЧКА!!!", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case 233:
                                toast =  Toast.makeText(getApplicationContext(), "СКОРО!!!", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case 350:
                                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alphanumb);
                                numb.startAnimation(anim);
                                break;
                            case 437:
                                toast =  Toast.makeText(getApplicationContext(), "ЛОЛ КЕК ЧЕБУРЕК!!!", Toast.LENGTH_SHORT);
                                LinearLayout toastContainer = (LinearLayout) toast.getView();
                                ImageView catImageView = new ImageView(getApplicationContext());
                                catImageView.setImageResource(R.drawable.trollface);
                                toastContainer.addView(catImageView, 0);
                                toast.show();
                                break;
                            case 500:
                                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotatenumb);
                                numb.startAnimation(anim);
                                toast =  Toast.makeText(getApplicationContext(), "Сейчас укачает", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case 570:
                                Intent intent2 = new Intent(MainActivity.this, Congratulations.class);
                                startActivity(intent2);
                                finish();
                                break;
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

    //Переменные пунктов контекстного меню
    final int MENU_SIZE_20 = 4;
    final int MENU_SIZE_40 = 5;
    final int MENU_SIZE_50 = 6;

    //Создаём контекстное меню
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.numb:
                menu.add(0, MENU_SIZE_20, 0, "20");
                menu.add(0, MENU_SIZE_40, 0, "40");
                menu.add(0, MENU_SIZE_50, 0, "50");
                break;
        }
    }

    //Описание взаимодействия с контекстным меню
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_SIZE_20:
                numb.setTextSize(20);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 20", Toast.LENGTH_SHORT);
                toastSize.show();
                break;
            case MENU_SIZE_40:
                numb.setTextSize(40);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 40", Toast.LENGTH_SHORT);
                toastSize.show();
                break;
            case MENU_SIZE_50:
                numb.setTextSize(50);
                toastSize =  Toast.makeText(getApplicationContext(), "Размер текста = 50", Toast.LENGTH_SHORT);
                toastSize.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //Описываем действие ползунка
    SeekBar.OnSeekBarChangeListener polzunokAction = new SeekBar.OnSeekBarChangeListener() {

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int width = progress+154;
            int height = progress+102;
            sizetPlusOne.width= width;
            sizetPlusOne.height = height;
            plusOne.requestLayout();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    //Создаём меню для чекбокса
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add(0, 1, 0, "Доп.настройки: ВКЛ");
        menu.add(0, 2, 0, "Доп.настройки: ВЫКЛ");
        menu.add(0, 3, 0, "Выход");
        return super.onCreateOptionsMenu(menu);

    }

    //Описываем действия кнопок меню
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                polzunok.setVisibility(View.VISIBLE);
                commit.setVisibility(View.VISIBLE);
                cursorImg.setVisibility(View.VISIBLE);
                commitForMenu.setVisibility(View.INVISIBLE);
                cursorMenuImage.setVisibility(View.INVISIBLE);
                break;
            case 2:
                polzunok.setVisibility(View.INVISIBLE);
                commit.setVisibility(View.INVISIBLE);
                cursorImg.setVisibility(View.INVISIBLE);
                commitForMenu.setVisibility(View.VISIBLE);
                cursorMenuImage.setVisibility(View.VISIBLE);
                break;
            case 3:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
