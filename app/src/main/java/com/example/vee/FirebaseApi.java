package com.example.vee;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseApi {

    @Provides
    @Singleton
    FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Provides
    @Singleton
    FirebaseUser getFirebaseCurrentUser(FirebaseAuth auth) {
        return auth.getCurrentUser();
    }


    @Provides
    @Singleton
    FirebaseDatabase getFirebaseDataBase() {
        return FirebaseDatabase.getInstance();
    }
}
