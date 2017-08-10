package com.smartapps.smartkids.smartkids.Controlleur;

import android.content.Intent;

import com.smartapps.smartkids.smartkids.Modele.Configuration;
import com.smartapps.smartkids.smartkids.Modele.Partie;
import com.smartapps.smartkids.smartkids.View.JeuActivity;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class JeuActivityControlleur {

    private JeuActivity ja;
    private Partie p;
    private Configuration config;

    public JeuActivityControlleur(JeuActivity ja) {
        this.ja = ja;
        this.config = parseIntentToConfiguration(this.ja.getIntent());
        this.p = new Partie();
    }

    private Configuration parseIntentToConfiguration(Intent i) {// parse l'intent..
        return new Configuration();
    }

    public void setUp() {
        this.p.creerLesJeueurs();
        this.p.lancePartie();
    }

    public boolean isDetectionTouche() {
        return p.isDialer();
    }

    public int getScreenW() {
        return this.ja.getWindowManager().getDefaultDisplay().getWidth();
    }

    public int getScreenH() {
        return this.ja.getWindowManager().getDefaultDisplay().getHeight();
    }

    public void notifyAttaque(AttaqueEnum at) {
        if (at == AttaqueEnum.DaD) {
        } else if (at == AttaqueEnum.DaG) {
        } else if (at == AttaqueEnum.GaG) {
        } else if (at == AttaqueEnum.GaD) {
        }
    }
}
