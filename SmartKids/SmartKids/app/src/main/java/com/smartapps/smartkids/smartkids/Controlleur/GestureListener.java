package com.smartapps.smartkids.smartkids.Controlleur;


import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public final class GestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_DISTANCE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private JeuActivityControlleur jac;
    private int displayW;
    private int displayH;
    public GestureListener(JeuActivityControlleur jac) {
        this.jac = jac;
        this.displayW = this.jac.getScreenW();
        this.displayH = this.jac.getScreenH();

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    /* @Override
     public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
         float distanceX = e2.getX() - e1.getX();
         float distanceY = e2.getY() - e1.getY();
         if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
             if (distanceX > 0) {
                 onSwipeRight();
             } else {
                 onSwipeLeft();
             }
             return true;
         }
         return false;
     }
 */

    private boolean estDansC1(int x, int y){
        return  x > this.displayW /2 && y < this.displayH /2;
    }

    private boolean estDansC2(int x, int y){
        return  x < this.displayW /2 && y < this.displayH /2;
    }

    private boolean estDansC3(int x, int y){
        return  x < this.displayW /2 && y > this.displayH /2;
    }

    private boolean estDansC4(int x, int y){
        return  x > this.displayW /2 && y > this.displayH /2;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if(this.jac.isDetectionTouche()){
            if((this.displayH / 2) < e1.getY() && this.displayH /2 > e2.getY()){
                if(estDansC3((int)e1.getX(), (int)e1.getY())){
                    if(estDansC2((int)e2.getX(), (int)e2.getY())){
                        this.jac.notifyAttaque(AttaqueEnum.GaG);
                        //notify
                    }else if(estDansC1((int)e2.getX(), (int)e2.getY())){
                        this.jac.notifyAttaque(AttaqueEnum.GaD);
                        //notify
                    }
                }else if(estDansC4((int)e1.getX(), (int)e1.getY())){
                    if(estDansC2((int)e2.getX(), (int)e2.getY())){
                        this.jac.notifyAttaque(AttaqueEnum.DaG);
                        //notify
                    }else if(estDansC1((int)e2.getX(), (int)e2.getY())){
                        this.jac.notifyAttaque(AttaqueEnum.DaD);
                        //notify
                    }
                }
            }
        }
        /*int dy = Math.abs((int) distanceY);
        if (ssettings.get(3)) {
            if (ssettings.get(5)) {
                if (e1.getX() > (display.getWidth() * 2 / 3) && e2.getX() > (display.getWidth() * 2 / 3)) {
                    if (dy % 5 == 2 && distanceY > 0 && distanceX < 10) {
                        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                                AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                    } else if (dy % 5 == 2 && distanceY < 0 && distanceX < 10) {
                        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                                AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                        return true;
                    }
                }
            } else if (ssettings.get(4)) {
                if (e1.getX() < (display.getWidth() * 2 / 3) && e2.getX() < (display.getWidth() * 2 / 3)) {
                    if (dy % 5 == 2 && distanceY > 0 && distanceX < 10) {
                        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                                AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                    } else if (dy % 5 == 2 && distanceY < 0 && distanceX < 10) {
                        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                                AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                        return true;
                    }
                }
            }
        }*/
        return false;
    }
}