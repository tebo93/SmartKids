package com.smartapps.test.test.Controlleur.Views.LogIn;

/**
 * Created by Esteban Puello on 8/08/2017.
 */

import android.content.Intent;
import android.os.AsyncTask;

import com.smartapps.test.test.R;
import com.smartapps.test.test.View.InformationA;
import com.smartapps.test.test.View.InformationSpecialA;
import com.smartapps.test.test.View.LoginA;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private final String mEmail;
    private final String mPassword;
    private LoginA la;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    public UserLoginTask(LoginA la, String email, String password) {
        this.mEmail = email;
        this.mPassword = password;
        this.la = la;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.
        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        la.setMAuthTaskToNull();
        la.showProgress(false);

        if (success) {
            //Intent i = new Intent(la.getApplicationContext(), InformationA.class);
            Intent i = new Intent(la.getApplicationContext(), InformationSpecialA.class);
            i.putExtra("user", mEmail);
            la.startActivity(i);
            //finish();
        } else {
            la.getmPasswordView().setError(la.getString(R.string.error_incorrect_password));
            la.getmPasswordView().requestFocus();
        }
    }

    @Override
    protected void onCancelled() {
        la.setMAuthTaskToNull();
        la.showProgress(false);
    }
}
