package com.smartapps.test.test.Controlleur.Views.LogIn;

import android.provider.ContactsContract;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

interface ProfileQuery {
    String[] PROJECTION = {
            ContactsContract.CommonDataKinds.Email.ADDRESS,
            ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
    };

    int ADDRESS = 0;
    int IS_PRIMARY = 1;
}
