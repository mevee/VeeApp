package com.example.vee;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import dagger.internal.DaggerCollections;

public class MyApplication extends Application {
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        Log.d("MyApplication","Oncreate");
        super.onCreate();
        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return apiComponent;
    }
}
