package com.example.spartahack.spartahack2016;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ryan on 11/3/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        Parse.initialize(this, Keys.PARSE_APP_ID, Keys.PARSE_API_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);

    }
}
