package com.smartapps.smartkids.smartkids.Modele;

import com.smartapps.smartkids.smartkids.Controlleur.AttaqueEnum;
import com.smartapps.smartkids.smartkids.Controlleur.MainEnum;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public abstract class JeueurA {
    Main mainGauche, mainDroit;

    public abstract AttaqueEnum attaque(JeueurA j);
    public abstract AttaqueEnum attaque(JeueurA j, AttaqueEnum ae);

    public boolean isMainDisponible(MainEnum me) {
        if (me == MainEnum.DROIT) {
            return mainDroit.getDoigtTendu() != 0;
        } else {
            return mainGauche.getDoigtTendu() != 0;
        }
    }

    public void estAttaque(MainEnum me, int cant){
        if(me == MainEnum.GAUCHE){
            mainGauche.estAttaque(cant);
        }else{
            mainDroit.estAttaque(cant);
        }
    }
}
