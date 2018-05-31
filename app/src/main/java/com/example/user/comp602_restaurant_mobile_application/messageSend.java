package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.util.List;

public class messageSend extends AppCompatActivity{
    String num1 = "5554";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        TextView oinfor =(TextView)findViewById(R.id.detail);
        final String sID=getIntent().getStringExtra("orderinfor");
        oinfor.setText(sID);

        Button button1 =(Button)this.findViewById(R.id.send);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=num1;
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

        Button button2 = (Button)this.findViewById(R.id.code);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent generateCode = new Intent(messageSend.this, generateQR.class);
                generateCode.putExtra("codeinfor",sID);
                startActivity(generateCode);
            }
        });

        Button button3 = (Button)this.findViewById(R.id.scan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanCode = new Intent(messageSend.this, scanQR.class);
                scanCode.putExtra("codeinfor",sID);
                startActivity(scanCode);
            }
        });
    }
}
