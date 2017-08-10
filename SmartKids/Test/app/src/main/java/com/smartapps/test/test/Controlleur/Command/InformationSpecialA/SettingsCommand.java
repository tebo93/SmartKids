package com.smartapps.test.test.Controlleur.Command.InformationSpecialA;

import android.app.Activity;
import android.content.Intent;
import com.smartapps.test.test.Controlleur.Command.Command;
import com.smartapps.test.test.View.SettingsA;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class SettingsCommand implements Command {

    private Activity a;

    public SettingsCommand(Activity a){
        this.a = a;
    }

    @Override
    public void execute(){
        Intent i = new Intent(a, SettingsA.class);
        a.startActivity(i);
    }
}
