// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.vee;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiModule_ProvidesGsonFactory implements Factory<Gson> {
  private final ApiModule module;

  public ApiModule_ProvidesGsonFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return Preconditions.checkNotNull(
        module.providesGson(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Gson> create(ApiModule module) {
    return new ApiModule_ProvidesGsonFactory(module);
  }

  public static Gson proxyProvidesGson(ApiModule instance) {
    return instance.providesGson();
  }
}
