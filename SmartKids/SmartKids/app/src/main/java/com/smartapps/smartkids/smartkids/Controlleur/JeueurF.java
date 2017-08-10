package com.smartapps.smartkids.smartkids.Controlleur;

import com.smartapps.smartkids.smartkids.Modele.Jeueur;
import com.smartapps.smartkids.smartkids.Modele.JeueurA;
import com.smartapps.smartkids.smartkids.Modele.JeueurM;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class JeueurF {

    public static JeueurA createJeueur(String type){
        if(type.contentEquals("H")){
            return new Jeueur();
        }else if (type.contentEquals("M")){
            return new JeueurM();
        }
        return null;
    }
}
