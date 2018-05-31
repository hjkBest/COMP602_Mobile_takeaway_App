package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.yzq.zxinglibrary.encode.CodeCreator;
import com.google.zxing.WriterException;
public class generateQR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        createQRCode();
    }

    private void createQRCode(){
        ImageView code = (ImageView)findViewById(R.id.QRCODE);
        final String Cinfor=getIntent().getStringExtra("codeinfor");
        Cinfor.trim();
        Bitmap bitmap = null;
        try {
            bitmap = CodeCreator.createQRCode(Cinfor, 400, 400, null);
        }catch (WriterException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            code.setImageBitmap(bitmap);
        }
    }
}
