// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.modules;

import com.dt.psychology.presenter.fragments.HomeFPresenter;
import com.dt.psychology.presenter.fragments.HomeFPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FragmentModule_ProvideHomeFPresenterFactory implements Factory<HomeFPresenter> {
  private final FragmentModule module;

  private final Provider<HomeFPresenterImpl> homeFPresenterProvider;

  public FragmentModule_ProvideHomeFPresenterFactory(
      FragmentModule module, Provider<HomeFPresenterImpl> homeFPresenterProvider) {
    assert module != null;
    this.module = module;
    assert homeFPresenterProvider != null;
    this.homeFPresenterProvider = homeFPresenterProvider;
  }

  @Override
  public HomeFPresenter get() {
    return Preconditions.checkNotNull(
        module.provideHomeFPresenter(homeFPresenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeFPresenter> create(
      FragmentModule module, Provider<HomeFPresenterImpl> homeFPresenterProvider) {
    return new FragmentModule_ProvideHomeFPresenterFactory(module, homeFPresenterProvider);
  }
}
