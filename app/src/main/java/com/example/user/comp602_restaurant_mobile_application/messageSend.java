package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class messageSend extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        TextView oinfor =(TextView)findViewById(R.id.detail);
        String sID=getIntent().getStringExtra("orderinfor");
        oinfor.setText(sID);
        Button button =(Button)this.findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mobileText =(EditText)findViewById(R.id.mobile);
                String number=mobileText.getText().toString();
                TextView oinfor =(TextView)findViewById(R.id.detail);
                String message=oinfor.getText().toString();
                if(message!=null){
                    SmsManager smsManager=SmsManager.getDefault();
                    List<String> texts=smsManager.divideMessage(message);
                    for(String text:texts)
                    {
                        smsManager.sendTextMessage(number,null,text,null,null);
                        Log.i("sms","send a message");
                        Toast.makeText(getApplicationContext(),"SENT",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
