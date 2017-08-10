package com.smartapps.test.test.View;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.smartapps.test.test.Controlleur.Views.LogIn.LogInAController;
import com.smartapps.test.test.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginA extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private LogInAController liac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        this.liac = new LogInAController(this);
        this.liac.setUp();
        this.liac.populateAutoComplete();
    }

    public View getmLoginFormView() {
        return mLoginFormView;
    }

    public EditText getmPasswordView() {
        return mPasswordView;
    }

    public AutoCompleteTextView getmEmailView() {
        return mEmailView;
    }

    public View getmProgressView() {
        return mProgressView;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        this.liac.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        this.liac.showProgress(show);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return this.liac.onCreateLoader(i, bundle);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        this.liac.onLoadFinished(cursorLoader, cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
    }

    public void setMAuthTaskToNull() {
        this.liac.setMAuthTaskToNull();
    }

}

