// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.vee;

import dagger.MembersInjector;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Retrofit> retrofitProvider;

  public MainActivity_MembersInjector(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Retrofit> retrofitProvider) {
    return new MainActivity_MembersInjector(retrofitProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectRetrofit(instance, retrofitProvider.get());
  }

  public static void injectRetrofit(MainActivity instance, Retrofit retrofit) {
    instance.retrofit = retrofit;
  }
}
