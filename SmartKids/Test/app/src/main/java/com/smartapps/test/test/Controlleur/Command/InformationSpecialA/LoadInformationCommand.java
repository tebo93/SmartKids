package com.smartapps.test.test.Controlleur.Command.InformationSpecialA;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.smartapps.test.test.Controlleur.Command.Command;
import com.smartapps.test.test.Controlleur.Pager.ViewPagerAdapter;
import com.smartapps.test.test.R;
import com.smartapps.test.test.View.InformationSpecialA;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class LoadInformationCommand implements Command {

    private InformationSpecialA isa;
    private String[] gallery;
    private String cancer;

    public LoadInformationCommand(InformationSpecialA isa, String[] gallery, String cancer) {
        this.isa = isa;
        this.gallery = gallery;
    }

    @Override
    public void execute() {
        ConstraintLayout cl = (ConstraintLayout) isa.findViewById(R.id.ci_cl);
        cl.removeAllViews();
        LinearLayout ll = (LinearLayout) isa.getLayoutInflater().inflate(R.layout.basic_information_la, null);
        cl.addView(ll);
        LinearLayout ll_ = (LinearLayout) ll.findViewById(R.id.bi_ll);
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        ll_.addView(new Button(isa));
        AsyncTask at = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    Thread.sleep(2000);
                    isa.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadGallery();
                        }
                    });
                } catch (InterruptedException e) {
                    return false;
                }
                return null;
            }
        };
        at.execute();
        //loadGallery();
    }

    private void loadGallery() {
        ViewPager vp = (ViewPager) isa.findViewById(R.id.bi_vp);
        ViewPagerAdapter vpa = new ViewPagerAdapter(this.isa, this.gallery);
        vp.setAdapter(vpa);
    }
}
