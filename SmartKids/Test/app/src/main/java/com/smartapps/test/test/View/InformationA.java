package com.smartapps.test.test.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.smartapps.test.test.Controlleur.Views.InformationA.InformationAController;
import com.smartapps.test.test.R;

public class InformationA extends AppCompatActivity {

    private InformationAController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ExpandableListView elv = (ExpandableListView) findViewById(R.id.elvInformation);
        this.controller = new InformationAController(this, elv);
        elv.setAdapter(this.controller.getAdapter(""));
        controller.setUp();
    }
}
