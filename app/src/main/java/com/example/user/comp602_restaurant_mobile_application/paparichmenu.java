package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class paparichmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paparichmenu);

        ImageButton M1 = (ImageButton) findViewById(R.id.imageButton1);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder M1b = new AlertDialog.Builder(paparichmenu.this);
                View M1bview = getLayoutInflater().inflate(R.layout.dialog_select,null);
                Button Cbutton = (Button) M1bview.findViewById(R.id.confirmbutton);
                Cbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(paparichmenu.this,"Confirm!!!",Toast.LENGTH_SHORT).show();
                    }
                });

                M1b.setView(M1bview);
                AlertDialog dialog = M1b.create();
                dialog.show();
            }
        });
    }
}
