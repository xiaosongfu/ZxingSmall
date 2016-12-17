package com.fuxiaosong.zxingsmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fuxiaosong.zxingsmall.zxing.activity.CaptureActivity;

/**
 * MainActivity
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月16日
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 启动 GenerateQRCodeActivity ，在该界面里生成二维码图片
     *
     * @param view view
     */
    public void generateQRCode(View view){
        Intent intent = new Intent(this, GenerateQRCodeActivity.class);
        startActivity(intent);
    }


    // REQUEST_CODE
    private static final int REQUEST_CODE = 100;

    /**
     * 启动  ，开始二维码的扫描
     *
     * @param view view
     */
    public void scanQRCode(View view){
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    /**
     * onActivityResult 用于接收二维码扫描结果
     *
     * @param requestCode requestCode
     * @param resultCode resultCode
     * @param data data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Toast.makeText(this, scanResult, Toast.LENGTH_LONG).show();
        }
    }
}