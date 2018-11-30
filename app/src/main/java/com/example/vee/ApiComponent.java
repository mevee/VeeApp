package com.example.vee;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules ={AppModule.class,ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
