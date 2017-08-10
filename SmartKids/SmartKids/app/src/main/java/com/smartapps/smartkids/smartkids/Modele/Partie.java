package com.smartapps.smartkids.smartkids.Modele;

import com.smartapps.smartkids.smartkids.Controlleur.JeueurF;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class Partie {

    private JeueurA jeueur, machine;
    private PartieEtat pe;
    private boolean dialer;

    public Partie(){
        this.pe = PartieEtat.EN_CONFIGURATION;
    }

    public boolean isDialer() {
        return dialer;
    }

    public void setEtat(PartieEtat pe){
        this.pe = pe;
    }
    public void misEnPlace(){

    }

    public void creerLesJeueurs() {
        this.jeueur = JeueurF.createJeueur("H");
        this.machine = JeueurF.createJeueur("M");
    }

    public void lancePartie(){
        this.dialer = Math.random() < 0.5;
        this.pe = PartieEtat.EN_JOUE;
        machineAttaque();
    }
    public void machineAttaque(){
        if(!dialer){
            this.machine.attaque(jeueur);
        }
    }

}
