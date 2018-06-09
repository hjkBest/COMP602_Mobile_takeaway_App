package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.yzq.zxinglibrary.encode.CodeCreator;
import com.google.zxing.WriterException;
import java.util.List;
import java.util.UUID;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class generateQR extends AppCompatActivity {
    final String uniqueID = UUID.randomUUID().toString();
    String time ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        setTitle("Order Detail");

        final Calendar calendar = Calendar.getInstance();
        final int hour   = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        final TimePickerDialog timePickerDialog = new TimePickerDialog(this, setting, hour, minute, true);
        timePickerDialog.show();
    }

    private void createQRCode(){
        String Cinfor=getIntent().getStringExtra("codeinfor");
        String phonenum=getIntent().getStringExtra("phone");

        ImageView code = (ImageView)findViewById(R.id.QRCODE);
        Cinfor = "Pick Up Time: " + time + "\n" + Cinfor;

        TextView t1 = (TextView)findViewById(R.id.orderdetail);
        t1.setText(Cinfor);

        Cinfor = "UID: " + uniqueID + "\n" + Cinfor;
        Bitmap bitmap = null;
        try {
            bitmap = CodeCreator.createQRCode(Cinfor, 400, 400, null);
        }catch (WriterException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            code.setImageBitmap(bitmap);
        }
        sendorder(Cinfor,phonenum);
    }

    TimePickerDialog.OnTimeSetListener setting = new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute)
        {
            time = hour + " : " + minute;
            createQRCode();
        }
    };

    private void sendorder(String str,String number) {
        SmsManager smsManager = SmsManager.getDefault();
        List<String> texts = smsManager.divideMessage(str);
        for (String text : texts) {
            smsManager.sendTextMessage(number, null, text, null, null);
            Log.i("sms", "send a message");
            Toast.makeText(getApplicationContext(), "SENT", Toast.LENGTH_SHORT).show();
        }
    }
}
