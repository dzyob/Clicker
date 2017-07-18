package p0141menuadv.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnActTwo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActTwo = (Button) findViewById(R.id.btnActTwo);

        View.OnClickListener oncBtn = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnActTwo:
                        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
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
