// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.modules;

import com.dt.psychology.presenter.activitis.AskQuestionPresenter;
import com.dt.psychology.presenter.activitis.AskQuestionPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ActivityModule_ProvideAskQuestionPresenterImplFactory
    implements Factory<AskQuestionPresenter> {
  private final ActivityModule module;

  private final Provider<AskQuestionPresenterImpl> askQuestionPresenterProvider;

  public ActivityModule_ProvideAskQuestionPresenterImplFactory(
      ActivityModule module, Provider<AskQuestionPresenterImpl> askQuestionPresenterProvider) {
    assert module != null;
    this.module = module;
    assert askQuestionPresenterProvider != null;
    this.askQuestionPresenterProvider = askQuestionPresenterProvider;
  }

  @Override
  public AskQuestionPresenter get() {
    return Preconditions.checkNotNull(
        module.provideAskQuestionPresenterImpl(askQuestionPresenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AskQuestionPresenter> create(
      ActivityModule module, Provider<AskQuestionPresenterImpl> askQuestionPresenterProvider) {
    return new ActivityModule_ProvideAskQuestionPresenterImplFactory(
        module, askQuestionPresenterProvider);
  }
}