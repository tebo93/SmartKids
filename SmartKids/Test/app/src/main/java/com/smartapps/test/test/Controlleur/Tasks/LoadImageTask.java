package com.smartapps.test.test.Controlleur.Tasks;
/**
 * Created by Esteban Puello on 28/11/2016.
 * This class allows user to load an image from internet into a ImageView object
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.smartapps.test.test.R;

import java.io.InputStream;
import java.net.URL;

public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView iv;
    private Context c;

    /**
     * Using this constructor the image will be loaded on the image view
     *
     * @param iv ImageView instance
     */
    public LoadImageTask(Context c, ImageView iv) {
        this.iv = iv;
        this.c = c;
    }


    @Override
    protected Bitmap doInBackground(String... args) {
        try {
            InputStream is = (InputStream) new URL(args[0]).getContent();
            Bitmap bm = BitmapFactory.decodeStream(is);
            is.close();
            return bm;
        } catch (Exception e) {
            e.printStackTrace();
            return BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_menu_error);

        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap newBitmap = getFinalImage(bitmap, 700);
            iv.setImageBitmap(newBitmap);
        }
    }

    private static Bitmap getFinalImage(Bitmap bm, int max) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        if (width > max) {
            float rate = (float) width / height;
            width = max;
            Float d = width / rate;
            height = d.intValue();
        } else if (height > max) {
            float rate = (float) height / width;
            height = max;
            Float d = height / rate;
            width = d.intValue();
        }
        return Bitmap.createScaledBitmap(bm, width,
                height, false);
    }
}
