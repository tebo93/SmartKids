package com.smartapps.smartkids.smartkids.Modele;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Esteban Puello on 10/08/2017.
 */

public class Configuration {
    Map<String, Object> mConfiguration;

    public Configuration(){
        this.mConfiguration = new HashMap<>();
    }
    public Configuration(Map<String, Object> map){
        this.mConfiguration = map;
    }

    public Map getConfigurations(){
        return mConfiguration;
    }

    public Object getConfiguration(String key){
        return this.mConfiguration.get(key);
    }
}
