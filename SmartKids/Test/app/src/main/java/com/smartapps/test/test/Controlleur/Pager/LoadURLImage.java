package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.smartapps.test.test.Controlleur.Tasks.LoadImageTask;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class LoadURLImage {


    private LoadURLImage() {
    }


    public static void loadImage(Context c, ImageView iv, String element) {
        LoadImageTask lit = new LoadImageTask(c, iv);
        lit.execute(element);
    }
}
