package com.smartapps.test.test.Controlleur.Views.InformationSpecialA;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.smartapps.test.test.Controlleur.Command.Command;
import com.smartapps.test.test.Controlleur.Command.InformationSpecialA.LoadInformationCommand;
import com.smartapps.test.test.Controlleur.Command.InformationSpecialA.SettingsCommand;
import com.smartapps.test.test.R;
import com.smartapps.test.test.View.InformationSpecialA;
import static android.Manifest.permission.ACCESS_NETWORK_STATE;
import static android.Manifest.permission.INTERNET;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

public class InformationSpecialAController {

    private InformationSpecialA isa;
    private Command settingsCommand;
    private Command searchCommand;
    private Toolbar toolbar;
    private static final String[] PERMISSIONS_NEEDED ={INTERNET, ACCESS_NETWORK_STATE};

    public InformationSpecialAController(InformationSpecialA isa){
        this.isa = isa;
        this.settingsCommand = new SettingsCommand(this.isa);
        this.searchCommand = new LoadInformationCommand(this.isa, new String[]{
                "http://www.laboiteverte.fr/wp-content/uploads/2016/09/peinture-tourbillon-animation-05.gif",
                "http://www.eluniversal.com.co/sites/default/files/styles/630x415/public/201708/peajes.jpg",
                "https://etsmtl.ca/ETS/media/Prive/Accueil/logo_ets.png?r=d&width=93&height=43",
                "https://upload.wikimedia.org/wikipedia/commons/a/ac/Raus_-_Roy_Puello_2.jpg",
                "https://www.google.ca/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png",
                "https://tctechcrunch2011.files.wordpress.com/2015/08/safe_image.gif",
                R.drawable.ic_menu_about + ""
        }, "");
    }

    public void setUp(Toolbar toolbar){
        this.toolbar = toolbar;
        FloatingActionButton fab = (FloatingActionButton) isa.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) isa.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this.isa, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) isa.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this.isa);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            this.settingsCommand.execute();
        } else if (id == R.id.nav_bookmarks) {

        } else if (id == R.id.nav_search) {
            this.searchCommand.execute();
        } else if (id == R.id.nav_share) {

        }else if (id == R.id.nav_calendar) {

        }

        DrawerLayout drawer = (DrawerLayout) this.isa.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            this.settingsCommand.execute();
            return true;
        }
        return false;
    }
}
