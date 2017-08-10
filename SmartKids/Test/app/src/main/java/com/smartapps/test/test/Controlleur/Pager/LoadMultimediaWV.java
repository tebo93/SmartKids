package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.smartapps.test.test.Controlleur.Dialogs.Dialog;

/**
 * Created by Esteban Puello on 9/08/2017.
 */

public class LoadMultimediaWV extends LoadMultimediaA {

    public LoadMultimediaWV(Context c, String file) {
        this.c = c;
        this.file = file;
    }

    public View generateView() {
        final WebView wv = new WebView(c);
        final WebView clone = new WebView(c);
        wv.loadUrl(file);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                view.loadUrl("about:blank");//change por message
            }
        });
        wv.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        clone.loadUrl(file);
        clone.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                view.loadUrl("about:blank");//change por message
            }
        });
        clone.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        wv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clone.getParent() != null) {
                    ViewParent parent = clone.getParent();
                    ((ViewGroup) parent).removeView(clone);
                }
                Dialog.openViewAsDialog(c, clone);
                clone.getSettings().setLoadWithOverviewMode(true);
                clone.getSettings().setUseWideViewPort(true);
                return false;
            }
        });
        return wv;
    }
}
