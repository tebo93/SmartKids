package com.smartapps.smartkids.smartkids.Controlleur;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;


    public OnSwipeTouchListener(GestureDetector gl) {
        gestureDetector = gl;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
