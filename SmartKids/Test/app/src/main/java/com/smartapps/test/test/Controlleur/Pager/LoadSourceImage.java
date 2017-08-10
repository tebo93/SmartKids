package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class LoadSourceImage {

    private LoadSourceImage() {
    }

    public static void loadImage(Context c, ImageView iv, String element) {
        Bitmap bm = BitmapFactory.decodeResource(c.getResources(), Integer.parseInt(element));
        iv.setImageBitmap(bm);
    }
}
