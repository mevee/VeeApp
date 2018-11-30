package com.example.vee;

import android.app.Application;
import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class Vee extends Application {
    static FirebaseApp myFirevbaseApp;
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
//        if (!FirebaseApp.getApps(this).isEmpty()) {
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        }
       FirebaseApp.initializeApp(Vee.this);
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static FirebaseApp getFirebaseAppInitialized() {
        if (myFirevbaseApp == null)
            myFirevbaseApp = FirebaseApp.initializeApp(getContext());

        return myFirevbaseApp;
    }
}
