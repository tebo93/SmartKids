package com.smartapps.smartkids.smartkids.Modele;

import com.smartapps.smartkids.smartkids.Controlleur.AttaqueEnum;
import com.smartapps.smartkids.smartkids.Controlleur.MainEnum;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class JeueurM extends JeueurA {
    @Override
    public AttaqueEnum attaque(JeueurA j) {
        if (!j.isMainDisponible(MainEnum.GAUCHE) && !j.isMainDisponible(MainEnum.DROIT)) {
            return null;
        }
        if (!isMainDisponible(MainEnum.GAUCHE) && !isMainDisponible(MainEnum.DROIT)) {
            return null;
        }
        MainEnum meAAttaque = mainAAttaque(j);
        MainEnum meAttaque = mainAAttaque(this);
        j.estAttaque(meAAttaque,
                meAttaque == MainEnum.GAUCHE ?
                        this.mainGauche.getDoigtTendu() :
                        this.mainDroit.getDoigtTendu());
        return null;
    }

    @Override
    public AttaqueEnum attaque(JeueurA j, AttaqueEnum ae) {
        return null;
    }

    private MainEnum mainAAttaque(JeueurA j) {
        double aux;
        for (; ; ) {
            aux = Math.random();
            if (aux < 0.5) {
                if (j.isMainDisponible(MainEnum.GAUCHE)) {
                    return MainEnum.GAUCHE;
                }
            } else {
                if (j.isMainDisponible(MainEnum.DROIT)) {
                    return MainEnum.DROIT;
                }
            }
        }
    }
}
