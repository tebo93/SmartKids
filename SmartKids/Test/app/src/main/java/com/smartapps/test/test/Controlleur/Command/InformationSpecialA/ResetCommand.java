package com.smartapps.test.test.Controlleur.Command.InformationSpecialA;

import com.smartapps.test.test.Controlleur.Command.Command;
import com.smartapps.test.test.View.InformationSpecialA;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class ResetCommand implements Command {
    private InformationSpecialA isa;
    public ResetCommand(InformationSpecialA isa){
        this.isa = isa;
    }
    @Override
    public void execute() {

    }
}
