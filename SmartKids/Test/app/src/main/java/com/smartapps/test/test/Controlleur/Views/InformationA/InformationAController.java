package com.smartapps.test.test.Controlleur.Views.InformationA;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Esteban Puello on 7/08/2017.
 */

public class InformationAController {

    private InformationAAdapter iaa;
    private InformationAGetData igd;
    private Context c;
    private ExpandableListView elv;
    public InformationAController(Context c, ExpandableListView elv) {
        this.elv = elv;
        this.c = c;
        this.igd = new InformationAGetData();
    }

    public void setUp(){
        this.elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        this.elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i < iaa.getGroupCount(); i++) {
                    if (groupPosition != i) {
                        elv.collapseGroup(i);
                    }
                }
            }
        });

        this.elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final AlertDialog alertDialog = new AlertDialog.Builder(c).create();
                alertDialog.setTitle("Hola");
                alertDialog.setMessage("Mundo");
                alertDialog.show();
                return false;
            }
        });
    }

    public InformationAAdapter getAdapter(String type) {
        ArrayList<String> als = this.igd.getMenusTitles("");
        HashMap<String, ArrayList<String>> hmsals = this.igd.getMenusElementsByTitle("");
        this.iaa = new InformationAAdapter(c, als, hmsals);
        return this.iaa;
    }
}
