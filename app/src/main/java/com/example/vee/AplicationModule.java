package com.example.vee;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AplicationModule {

    private final Application mApplication;

    public AplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }


}
