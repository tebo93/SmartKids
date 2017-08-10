package com.smartapps.test.test.Controlleur.Pager;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Context c;
    String[] files; //instead of using the id of the image, we can support http, local saved, and R
    LayoutInflater layoutInflater;
    View[] vs;

    public ViewPagerAdapter(Context c, String images[]) {
        this.c = c;
        this.files = images;
        layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vs = new View[files.length];
    }

    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        if (this.vs[position] == null) {
            LinearLayout ll = new LinearLayout(c);
            LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LoadMultimediaA lm = new LoadMultimedia(c, files[position]);
            ll.addView(lm.generateView(), lllp);
            //ll.addView(lm.generateView());
            this.vs[position] = ll;
        }
        container.addView(this.vs[position]);
        return this.vs[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
