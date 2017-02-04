package com.leslie.handlerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by leslie.fang on 2017-02-04.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {
    private ImageView imageView;

    public MyAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(params[0]);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            if (in != null) {
                bitmap = BitmapFactory.decodeStream(in);
            }
        } catch (Exception e) {

        }
        return bitmap;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
