package com.smartapps.smartkids.smartkids.View;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.TextView;

import com.smartapps.smartkids.smartkids.Controlleur.GestureListener;
import com.smartapps.smartkids.smartkids.Controlleur.JeuActivityControlleur;
import com.smartapps.smartkids.smartkids.Controlleur.OnSwipeTouchListener;
import com.smartapps.smartkids.smartkids.R;

public class JeuActivity extends AppCompatActivity {

    private JeuActivityControlleur jac;
    private TextView tv_mgm;
    private TextView tv_mdm;
    private TextView tv_mgj;
    private TextView tv_mdj;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        this.jac = new JeuActivityControlleur(this);
        getMains();
        this.jac.setUp();
    }

    private void getMains() {
        this.cl = (ConstraintLayout) findViewById(R.id.cl_AJ);
        this.cl.setOnTouchListener(new OnSwipeTouchListener(new GestureDetector(this, new GestureListener(this.jac))));
        this.tv_mdj = (TextView) findViewById(R.id.tv_AJ_MDJ);
        this.tv_mgj = (TextView) findViewById(R.id.tv_AJ_MGJ);
        this.tv_mdm = (TextView) findViewById(R.id.tv_AJ_MDM);
        this.tv_mgm = (TextView) findViewById(R.id.tv_AJ_MGM);
    }

}
