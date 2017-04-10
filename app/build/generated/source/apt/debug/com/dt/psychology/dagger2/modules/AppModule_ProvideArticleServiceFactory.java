// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.modules;

import com.dt.psychology.network.ArticleService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class AppModule_ProvideArticleServiceFactory implements Factory<ArticleService> {
  private final AppModule module;

  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideArticleServiceFactory(
      AppModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ArticleService get() {
    return Preconditions.checkNotNull(
        module.provideArticleService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ArticleService> create(
      AppModule module, Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideArticleServiceFactory(module, retrofitProvider);
  }

  /** Proxies {@link AppModule#provideArticleService(Retrofit)}. */
  public static ArticleService proxyProvideArticleService(AppModule instance, Retrofit retrofit) {
    return instance.provideArticleService(retrofit);
  }
}
