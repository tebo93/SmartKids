package com.smartapps.smartkids.smartkids.Modele;

import android.view.View;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class Main {
    public static final int DOIGT_MAIN = 5;
    public static final int START_MAIN = 1;
    private int doigtTendu = 1;

    public Main() {
    }

    public void estAttaque(int i) {
        doigtTendu = doigtTendu + i;
        if (doigtTendu > 5) {
            doigtTendu = doigtTendu - 5;
        } else if (doigtTendu == 5) {
            doigtTendu = 0;
        }
    }

    public int getDoigtTendu() {
        return doigtTendu;
    }
}
