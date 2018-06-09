package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayInfor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_infor);
        setTitle("Scan Result Page");
        SetTextTo();
    }

    public void SetTextTo(){
        TextView re2 =(TextView)findViewById(R.id.QRresult2);
        final String QRinfor=getIntent().getStringExtra("QRinfor");
        re2.setText(QRinfor);
    }

}
