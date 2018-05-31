package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.yanzhenjie.permission.AndPermission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Action;
import android.net.Uri;
import java.util.List;
import android.content.Intent;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;
import com.yzq.zxinglibrary.common.Constant;

public class scanQR extends AppCompatActivity {

    private int REQUEST_CODE_SCAN = 111;
    TextView re1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);
        ScanQR();


    }

    private void ScanQR(){
        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(scanQR.this, CaptureActivity.class);
                        ZxingConfig config = new ZxingConfig();
                        config.setPlayBeep(true);
                        config.setShake(true);
                        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                    }
                })

                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(scanQR.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                    }
                }).start();


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                re1 = (TextView)findViewById(R.id.QRresult1);
                re1.setText(content);

                Intent send = new Intent(scanQR.this, DisplayInfor.class);
                send.putExtra("QRinfor",content);
                startActivity(send);

            }
        }
    }

}
