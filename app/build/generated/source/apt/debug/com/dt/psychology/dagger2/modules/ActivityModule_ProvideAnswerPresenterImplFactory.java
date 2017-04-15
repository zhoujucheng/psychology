// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.modules;

import com.dt.psychology.presenter.activitis.AnswerPresenter;
import com.dt.psychology.presenter.activitis.AnswerPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ActivityModule_ProvideAnswerPresenterImplFactory
    implements Factory<AnswerPresenter> {
  private final ActivityModule module;

  private final Provider<AnswerPresenterImpl> answerPresenterProvider;

  public ActivityModule_ProvideAnswerPresenterImplFactory(
      ActivityModule module, Provider<AnswerPresenterImpl> answerPresenterProvider) {
    assert module != null;
    this.module = module;
    assert answerPresenterProvider != null;
    this.answerPresenterProvider = answerPresenterProvider;
  }

  @Override
  public AnswerPresenter get() {
    return Preconditions.checkNotNull(
        module.provideAnswerPresenterImpl(answerPresenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AnswerPresenter> create(
      ActivityModule module, Provider<AnswerPresenterImpl> answerPresenterProvider) {
    return new ActivityModule_ProvideAnswerPresenterImplFactory(module, answerPresenterProvider);
  }
}