// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.presenter.activitis;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

public final class ArticlePresenterImpl_Factory implements Factory<ArticlePresenterImpl> {
  private final MembersInjector<ArticlePresenterImpl> articlePresenterImplMembersInjector;

  public ArticlePresenterImpl_Factory(
      MembersInjector<ArticlePresenterImpl> articlePresenterImplMembersInjector) {
    assert articlePresenterImplMembersInjector != null;
    this.articlePresenterImplMembersInjector = articlePresenterImplMembersInjector;
  }

  @Override
  public ArticlePresenterImpl get() {
    return MembersInjectors.injectMembers(
        articlePresenterImplMembersInjector, new ArticlePresenterImpl());
  }

  public static Factory<ArticlePresenterImpl> create(
      MembersInjector<ArticlePresenterImpl> articlePresenterImplMembersInjector) {
    return new ArticlePresenterImpl_Factory(articlePresenterImplMembersInjector);
  }
}
