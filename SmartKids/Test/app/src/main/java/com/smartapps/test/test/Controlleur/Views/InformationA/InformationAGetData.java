package com.smartapps.test.test.Controlleur.Views.InformationA;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Esteban Puello on 7/08/2017.
 * Stub for creating basic data
 */

public class InformationAGetData {

    public ArrayList<String> getMenusTitles(String... args){
        ArrayList<String> als = new ArrayList<>();
        als.add("Menu 1");
        als.add("Menu 2");
        als.add("Menu 3");
        als.add("Menu 4");
        return als;
    }
    public HashMap<String, ArrayList<String>> getMenusElementsByTitle(String... args){
        HashMap<String, ArrayList<String>> hmsals = new HashMap<>();
        ArrayList<String> als = new ArrayList<>();
        als.add("Element 1");
        als.add("Element 2");
        als.add("Element 3");
        als.add("Element 4");
        hmsals.put("Menu 1", als);
        ArrayList<String> als2 = new ArrayList<>();
        als2.add("Element 1");
        als2.add("Element 2");
        als2.add("Element 3");
        hmsals.put("Menu 2", als2);
        ArrayList<String> als3 = new ArrayList<>();
        als3.add("Element 1");
        als3.add("Element 2");
        als3.add("Element 3");
        hmsals.put("Menu 3", als3);
        ArrayList<String> als4 = new ArrayList<>();
        als4.add("Element 1");
        als4.add("Element 2");
        als4.add("Element 3");
        hmsals.put("Menu 4", als4);
        return hmsals;
    }
}
