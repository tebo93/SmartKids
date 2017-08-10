package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.smartapps.test.test.Controlleur.Dialogs.Dialog;

/**
 * Created by Esteban Puello on 9/08/2017.
 */

public class LoadMultimediaHttpImage extends LoadMultimediaA {

    public LoadMultimediaHttpImage(Context c, String file) {
        this.c = c;
        this.file = file;
    }

    @Override
    public View generateView() {
        ImageView iv = new ImageView(c);
        final ImageView clone = new ImageView(c);
        LoadURLImage.loadImage(c, iv, file);
        LoadURLImage.loadImage(c, clone, file);
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clone.getParent() != null) {
                    ViewParent parent = clone.getParent();
                    ((ViewGroup) parent).removeView(clone);
                }
                Dialog.openViewAsDialog(c, clone);
                return false;
            }
        });
        return iv;
    }
}
