package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.smartapps.test.test.Controlleur.Dialogs.Dialog;
import com.smartapps.test.test.Controlleur.Views.GifMovieView;
import com.smartapps.test.test.Model.DisplayMessage;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Esteban Puello on 9/08/2017.
 */

public class LoadMultimediaCV extends LoadMultimediaA {
    ArrayList<DisplayMessage> aldms;
    public LoadMultimediaCV(Context c, String file) {
        this.c = c;
        this.file = file;
    }

    @Override
    View generateView() {
        final GifMovieView gmv = new GifMovieView(c);
//        LoadMultimediaCVAsyncTask lmcvat = new LoadMultimediaCVAsyncTask(this.c, this.file, gmv);
//        lmcvat.execute();
        AsyncTask at = new AsyncTask<Object, Void, Movie[]>() {
            @Override
            protected Movie[] doInBackground(Object[] params) {
                try {
                    URL url = new URL(file);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                    int aux = new Random(10).nextInt(100);
                    String filename = "file_" + aux + ".donne";
                    File path = c.getFilesDir();
                    File targetFile = new File(path, filename);
                    filename = targetFile.getPath();
                    System.out.println(filename);
                    FileOutputStream os = new FileOutputStream(targetFile);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    is.close();
                    os.close();
                    Movie[] ms = new Movie[]{
                            Movie.decodeStream(new FileInputStream(new File(filename))),
                            Movie.decodeStream(new FileInputStream(new File(filename)))
                    };
                    aldms = new ArrayList<>();
                    aldms.add(new DisplayMessage("Hola", 10, 1000, Color.WHITE, 35, Color.BLACK));
                    aldms.add(new DisplayMessage("mundo", 350, 1500, Color.WHITE, 35, Color.BLACK));
                    aldms.add(new DisplayMessage("Este es un mensaje de prueba", 610, 950, Color.WHITE, 35, Color.BLACK));
                    aldms.add(new DisplayMessage("Este es un mensaje de prueba", 100, 2050, Color.WHITE, 35, Color.BLACK));
                    aldms.add(new DisplayMessage("Este es un mensaje de prueba", 2500, 4900, Color.WHITE, 35, Color.BLACK));
                    return ms;
                } catch (Exception e) {
                    Log.e("LM BG Task", e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Movie[] ms) {
                try {
                    gmv.setMovie(new com.smartapps.test.test.Model.Movie(ms[0], aldms));
                    gmv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gmv.setPaused(!gmv.isPaused());
                        }
                    });
                    final GifMovieView clone = new GifMovieView(c);
                    clone.setMovie(new com.smartapps.test.test.Model.Movie(ms[1], aldms));
                    clone.setPaused(true);
                    gmv.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            if (clone.getParent() != null) {
                                ViewParent parent = clone.getParent();
                                ((ViewGroup) parent).removeView(clone);
                            }
                            clone.setPaused(false);
                            Dialog.openViewAsDialog(c, clone);
                            return false;
                        }
                    });
                } catch (Exception e) {
                    Log.e("LM OPE Task", e.getMessage());
                }
            }
        };
        at.execute();
        return gmv;
    }
}
