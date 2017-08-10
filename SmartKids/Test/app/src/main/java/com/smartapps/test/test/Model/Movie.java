package com.smartapps.test.test.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class Movie {
    private android.graphics.Movie m;
    private List<DisplayMessage> ldms;
    private List<DisplayMessage> in;

    public Movie(){
    }

    public Movie(android.graphics.Movie m, List<DisplayMessage> ldms) {
        this.m = m;
        this.ldms = ldms;
        this.in = new ArrayList<>();
    }

    public android.graphics.Movie getM() {
        return m;
    }

    public List<DisplayMessage> getLdms() {
        return ldms;
    }

    public void setM(android.graphics.Movie m) {
        this.m = m;
    }

    public List<DisplayMessage> searchMessageIn(int currentFrame) {
        this.in.clear();
        for (DisplayMessage dm :
                ldms) {
            if (dm.getStartPoint() <= currentFrame && dm.getEndPoint() >= currentFrame) {
                in.add(dm);
            }
        }
        return this.in;
    }

}
