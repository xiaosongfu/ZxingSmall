package com.fuxiaosong.zxingsmall;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.fuxiaosong.zxingsmall.zxing.encoding.EncodingHandler;

/**
 * GenerateQRCodeActivity
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月16日
 */
public class GenerateQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generateqrcode);
        try {
            Bitmap mBitmap = EncodingHandler.createQRCode("www.baidu.com", 300);
            ((ImageView)findViewById(R.id.image)).setImageBitmap(mBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}