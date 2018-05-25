package com.example.user.comp602_restaurant_mobile_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton r1 = (ImageButton) findViewById(R.id.papparich_clicked_button);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, paparichmenu.class);
                startActivity(intent);
            }
        });

        ImageButton r2 = (ImageButton) findViewById(R.id.kimchi_clicked_button);
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Kimchi.class);
                startActivity(intent);
            }
        });

        ImageButton r3 = (ImageButton) findViewById(R.id.cave_clicked_button);
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cave.class);
                startActivity(intent);
            }
        });

        ImageButton r4 = (ImageButton) findViewById(R.id.coco_clicked_button);
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, COCO.class);
                startActivity(intent);
            }
        });
    }
}
