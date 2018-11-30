package com.example.vee;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mAplication;

    public AppModule(Application mAplication) {
        this.mAplication = mAplication;
    }

    @Provides
    @Singleton
    public Application getApllication(){
        return mAplication;
    }
}