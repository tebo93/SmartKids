package com.smartapps.test.test.Controlleur.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class Dialog {
    public static void createSnakBarMessage(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public static AlertDialog openViewAsDialog(final Context x, final View view) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(x);
        alertDialog.setView(view);
        final AlertDialog ad = alertDialog.show();
        return ad;
    }

    public static AlertDialog openViewAsDialogClickClose(final Context x, final View view) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(x);
        alertDialog.setView(view);
        final AlertDialog ad = alertDialog.show();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.cancel();
            }
        });
        return ad;
    }

    public static void openDialog(Context x, String title, String message) {
        final AlertDialog alertDialog = new AlertDialog.Builder(x).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }

    public static void openBigDialog(Context x, final View view) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(x);
        alertDialog.setView(view);
        final AlertDialog ad = alertDialog.show();
        WindowManager.LayoutParams wmlp = new WindowManager.LayoutParams();
        wmlp.copyFrom(ad.getWindow().getAttributes());
        wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wmlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        ad.show();
        ad.getWindow().setAttributes(wmlp);
    }

}
