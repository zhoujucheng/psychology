// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.modules;

import com.dt.psychology.presenter.fragments.PersonalFPresenter;
import com.dt.psychology.presenter.fragments.PersonalFPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FragmentModule_ProvidePersonalFPresenterFactory
    implements Factory<PersonalFPresenter> {
  private final FragmentModule module;

  private final Provider<PersonalFPresenterImpl> personalFPresenterProvider;

  public FragmentModule_ProvidePersonalFPresenterFactory(
      FragmentModule module, Provider<PersonalFPresenterImpl> personalFPresenterProvider) {
    assert module != null;
    this.module = module;
    assert personalFPresenterProvider != null;
    this.personalFPresenterProvider = personalFPresenterProvider;
  }

  @Override
  public PersonalFPresenter get() {
    return Preconditions.checkNotNull(
        module.providePersonalFPresenter(personalFPresenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PersonalFPresenter> create(
      FragmentModule module, Provider<PersonalFPresenterImpl> personalFPresenterProvider) {
    return new FragmentModule_ProvidePersonalFPresenterFactory(module, personalFPresenterProvider);
  }

  /** Proxies {@link FragmentModule#providePersonalFPresenter(PersonalFPresenterImpl)}. */
  public static PersonalFPresenter proxyProvidePersonalFPresenter(
      FragmentModule instance, PersonalFPresenterImpl personalFPresenter) {
    return instance.providePersonalFPresenter(personalFPresenter);
  }
}
