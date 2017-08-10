package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.smartapps.test.test.Controlleur.Views.GifMovieView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * Created by Esteban Puello on 9/08/2017.
 */

class LoadMultimedia extends LoadMultimediaA {

    LoadMultimediaA lmi;

    public LoadMultimedia(Context c, String file) {
        this.c = c;
        this.file = file;
    }

    public View generateView() {
        if (file.toLowerCase().contains("gif")) {
            //Load Gif with WebView
            //lmi = new LoadMultimediaWV(c, file);
            //WebView wv = (WebView) lmi.generateView();
            //return wv;

            //Load gif within customview
            lmi = new LoadMultimediaCV(c, file);
            GifMovieView gmv = (GifMovieView) lmi.generateView();
            gmv.setBackgroundColor(Color.BLACK);
            return gmv;
        } else if ((file.toLowerCase().contains("http") || file.toLowerCase().contains("https"))) {
            lmi = new LoadMultimediaHttpImage(c, file);
            ImageView iv = (ImageView) lmi.generateView();
            return iv;
        } else if (file.contains("file:")) {
        } else {
            try {
                lmi = new LoadMultimediaRIcon(c, file);
                ImageView iv = (ImageView) lmi.generateView();
                return iv;
            } catch (Exception e) {

            }
        }
        return null;
    }


}
