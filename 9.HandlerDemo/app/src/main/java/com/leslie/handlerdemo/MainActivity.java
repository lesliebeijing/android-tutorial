package com.leslie.handlerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// 参考学习  http://blog.csdn.net/lmj623565791/article/details/38377229/
public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageview);
        imageView2 = (ImageView) findViewById(R.id.imageview2);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1000) {
                    Bitmap bitmap = (Bitmap) msg.obj;
                    imageView.setImageBitmap(bitmap);
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    if (in != null) {
                        Bitmap bitmap = BitmapFactory.decodeStream(in);
                        if (bitmap != null) {
                            Message message = new Message();
                            message.what = 1000;
                            message.obj = bitmap;

                            handler.sendMessage(message);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }.start();

        new MyAsyncTask(imageView2).execute("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
    }
}
