package com.example.user.comp602_restaurant_mobile_application;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;
import 	android.support.design.widget.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SDP MOBILE TAKEAWAY APP");
        SetUpHomePage();
        SetUpButtonBar();

    }

    //Set up the Main body of the Home Page
    public void SetUpHomePage(){
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

    //set up the button bar of the home page
    public void SetUpButtonBar(){
        BottomNavigationView view = (BottomNavigationView) findViewById(R.id.bnve);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_scan:
                        Intent scanCode = new Intent(MainActivity.this, scanQR.class);
                        //scanCode.putExtra("codeinfor",sID);
                        startActivity(scanCode);
                        break;
                    case R.id.menu_search:
                        Intent intent=new Intent(MainActivity.this,SearchViewTest.class);
                        startActivity(intent);
                        //add your code here
                        break;
                }
                return true;
            }
        });
    }
}
