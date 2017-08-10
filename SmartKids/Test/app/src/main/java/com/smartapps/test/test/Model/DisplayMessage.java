package com.smartapps.test.test.Model;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class DisplayMessage {
    private String message;
    private int startPoint;
    private int endPoint;
    private int backgroundColor;
    private int textColor;
    private int size;

    public DisplayMessage(String message, int startPoint, int endPoint, int textColor, int size, int backgroundColor) {
        this.message = message;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.textColor = textColor;
        this.size = size;
        this.backgroundColor = backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public String getMessage() {
        return message;
    }

    public int getSize() {
        return size;
    }
}
