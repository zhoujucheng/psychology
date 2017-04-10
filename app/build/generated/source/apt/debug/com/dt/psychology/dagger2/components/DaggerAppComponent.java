// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.dt.psychology.dagger2.components;

import android.content.Context;
import com.dt.psychology.components.NetworkChangeReceiver;
import com.dt.psychology.components.NetworkChangeReceiver_Factory;
import com.dt.psychology.components.NetworkChangeReceiver_MembersInjector;
import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.dagger2.modules.ActivityModule_ProvideActivityContextFactory;
import com.dt.psychology.dagger2.modules.ActivityModule_ProvideArticleDaoFactory;
import com.dt.psychology.dagger2.modules.ActivityModule_ProvideArticlePresenterImplFactory;
import com.dt.psychology.dagger2.modules.ActivityModule_ProvideLoginPresenterImplFactory;
import com.dt.psychology.dagger2.modules.ActivityModule_ProvideSignUpPresenterImplFactory;
import com.dt.psychology.dagger2.modules.AppModule;
import com.dt.psychology.dagger2.modules.AppModule_ProvideArticleServiceFactory;
import com.dt.psychology.dagger2.modules.AppModule_ProvideDaoSessionFactory;
import com.dt.psychology.dagger2.modules.AppModule_ProvideExecutorServiceFactory;
import com.dt.psychology.dagger2.modules.AppModule_ProvideOkHttpClientFactory;
import com.dt.psychology.dagger2.modules.AppModule_ProvideRetrofitFactory;
import com.dt.psychology.dagger2.modules.AppModule_ProvideUserServiceFactory;
import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.dagger2.modules.FragmentModule_ProvideDiscussionFPresenterFactory;
import com.dt.psychology.dagger2.modules.FragmentModule_ProvideHomeFPresenterFactory;
import com.dt.psychology.dagger2.modules.FragmentModule_ProvidePersonalFPresenterFactory;
import com.dt.psychology.domain.ArticleDao;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.network.ArticleService;
import com.dt.psychology.network.UserService;
import com.dt.psychology.presenter.activitis.ArticlePresenter;
import com.dt.psychology.presenter.activitis.ArticlePresenterImpl;
import com.dt.psychology.presenter.activitis.ArticlePresenterImpl_Factory;
import com.dt.psychology.presenter.activitis.ArticlePresenterImpl_MembersInjector;
import com.dt.psychology.presenter.activitis.LoginPresenter;
import com.dt.psychology.presenter.activitis.LoginPresenterImpl;
import com.dt.psychology.presenter.activitis.LoginPresenterImpl_Factory;
import com.dt.psychology.presenter.activitis.LoginPresenterImpl_MembersInjector;
import com.dt.psychology.presenter.activitis.SignUpPresenter;
import com.dt.psychology.presenter.activitis.SignUpPresenterImpl;
import com.dt.psychology.presenter.activitis.SignUpPresenterImpl_Factory;
import com.dt.psychology.presenter.activitis.SignUpPresenterImpl_MembersInjector;
import com.dt.psychology.presenter.fragments.DiscussionFPresenter;
import com.dt.psychology.presenter.fragments.DiscussionFPresenterImpl_Factory;
import com.dt.psychology.presenter.fragments.HomeFPresenter;
import com.dt.psychology.presenter.fragments.HomeFPresenterImpl;
import com.dt.psychology.presenter.fragments.HomeFPresenterImpl_Factory;
import com.dt.psychology.presenter.fragments.HomeFPresenterImpl_MembersInjector;
import com.dt.psychology.presenter.fragments.PersonalFPresenter;
import com.dt.psychology.presenter.fragments.PersonalFPresenterImpl_Factory;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.MyApplication_MembersInjector;
import com.dt.psychology.ui.activities.AnswersActivity;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.dt.psychology.ui.activities.ArticleActivity_MembersInjector;
import com.dt.psychology.ui.activities.ArticleDetailActivity;
import com.dt.psychology.ui.activities.EditDataActivity;
import com.dt.psychology.ui.activities.LoginActivity;
import com.dt.psychology.ui.activities.LoginActivity_MembersInjector;
import com.dt.psychology.ui.activities.MainActivity;
import com.dt.psychology.ui.activities.SignUpActivity;
import com.dt.psychology.ui.activities.SignUpActivity_MembersInjector;
import com.dt.psychology.ui.activities.SplashActivity;
import com.dt.psychology.ui.fragments.DiscussionFragment;
import com.dt.psychology.ui.fragments.DiscussionFragment_MembersInjector;
import com.dt.psychology.ui.fragments.HomeFragment;
import com.dt.psychology.ui.fragments.HomeFragment_MembersInjector;
import com.dt.psychology.ui.fragments.PersonalFragment;
import com.dt.psychology.ui.fragments.PersonalFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerAppComponent implements AppComponent {
  private Provider<ExecutorService> provideExecutorServiceProvider;

  private Provider<DaoSession> provideDaoSessionProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<UserService> provideUserServiceProvider;

  private MembersInjector<NetworkChangeReceiver> networkChangeReceiverMembersInjector;

  private Provider<NetworkChangeReceiver> networkChangeReceiverProvider;

  private MembersInjector<MyApplication> myApplicationMembersInjector;

  private Provider<ArticleService> provideArticleServiceProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideExecutorServiceProvider =
        DoubleCheck.provider(AppModule_ProvideExecutorServiceFactory.create(builder.appModule));

    this.provideDaoSessionProvider =
        DoubleCheck.provider(AppModule_ProvideDaoSessionFactory.create(builder.appModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(AppModule_ProvideOkHttpClientFactory.create(builder.appModule));

    this.provideRetrofitProvider =
        DoubleCheck.provider(
            AppModule_ProvideRetrofitFactory.create(
                builder.appModule, provideOkHttpClientProvider));

    this.provideUserServiceProvider =
        DoubleCheck.provider(
            AppModule_ProvideUserServiceFactory.create(builder.appModule, provideRetrofitProvider));

    this.networkChangeReceiverMembersInjector =
        NetworkChangeReceiver_MembersInjector.create(provideUserServiceProvider);

    this.networkChangeReceiverProvider =
        NetworkChangeReceiver_Factory.create(networkChangeReceiverMembersInjector);

    this.myApplicationMembersInjector =
        MyApplication_MembersInjector.create(
            provideExecutorServiceProvider,
            provideDaoSessionProvider,
            networkChangeReceiverProvider);

    this.provideArticleServiceProvider =
        DoubleCheck.provider(
            AppModule_ProvideArticleServiceFactory.create(
                builder.appModule, provideRetrofitProvider));
  }

  @Override
  public void inject(MyApplication myApplication) {
    myApplicationMembersInjector.injectMembers(myApplication);
  }

  @Override
  public ActivityComponent plus(ActivityModule activityModule) {
    return new ActivityComponentImpl(activityModule);
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }

  private final class ActivityComponentImpl implements ActivityComponent {
    private final ActivityModule activityModule;

    private Provider<ArticleDao> provideArticleDaoProvider;

    private MembersInjector<ArticlePresenterImpl> articlePresenterImplMembersInjector;

    private Provider<ArticlePresenterImpl> articlePresenterImplProvider;

    private Provider<ArticlePresenter> provideArticlePresenterImplProvider;

    private MembersInjector<ArticleActivity> articleActivityMembersInjector;

    private MembersInjector<LoginPresenterImpl> loginPresenterImplMembersInjector;

    private Provider<LoginPresenterImpl> loginPresenterImplProvider;

    private Provider<LoginPresenter> provideLoginPresenterImplProvider;

    private MembersInjector<LoginActivity> loginActivityMembersInjector;

    private Provider<Context> provideActivityContextProvider;

    private MembersInjector<SignUpPresenterImpl> signUpPresenterImplMembersInjector;

    private Provider<SignUpPresenterImpl> signUpPresenterImplProvider;

    private Provider<SignUpPresenter> provideSignUpPresenterImplProvider;

    private MembersInjector<SignUpActivity> signUpActivityMembersInjector;

    private ActivityComponentImpl(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.provideArticleDaoProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideArticleDaoFactory.create(
                  activityModule, DaggerAppComponent.this.provideDaoSessionProvider));

      this.articlePresenterImplMembersInjector =
          ArticlePresenterImpl_MembersInjector.create(
              DaggerAppComponent.this.provideArticleServiceProvider,
              DaggerAppComponent.this.provideExecutorServiceProvider,
              provideArticleDaoProvider);

      this.articlePresenterImplProvider =
          ArticlePresenterImpl_Factory.create(articlePresenterImplMembersInjector);

      this.provideArticlePresenterImplProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideArticlePresenterImplFactory.create(
                  activityModule, articlePresenterImplProvider));

      this.articleActivityMembersInjector =
          ArticleActivity_MembersInjector.create(provideArticlePresenterImplProvider);

      this.loginPresenterImplMembersInjector =
          LoginPresenterImpl_MembersInjector.create(
              DaggerAppComponent.this.provideUserServiceProvider);

      this.loginPresenterImplProvider =
          LoginPresenterImpl_Factory.create(loginPresenterImplMembersInjector);

      this.provideLoginPresenterImplProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideLoginPresenterImplFactory.create(
                  activityModule, loginPresenterImplProvider));

      this.loginActivityMembersInjector =
          LoginActivity_MembersInjector.create(provideLoginPresenterImplProvider);

      this.provideActivityContextProvider =
          DoubleCheck.provider(ActivityModule_ProvideActivityContextFactory.create(activityModule));

      this.signUpPresenterImplMembersInjector =
          SignUpPresenterImpl_MembersInjector.create(
              DaggerAppComponent.this.provideUserServiceProvider, provideActivityContextProvider);

      this.signUpPresenterImplProvider =
          SignUpPresenterImpl_Factory.create(signUpPresenterImplMembersInjector);

      this.provideSignUpPresenterImplProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideSignUpPresenterImplFactory.create(
                  activityModule, signUpPresenterImplProvider));

      this.signUpActivityMembersInjector =
          SignUpActivity_MembersInjector.create(provideSignUpPresenterImplProvider);
    }

    @Override
    public void inject(MainActivity mainActivity) {
      MembersInjectors.<MainActivity>noOp().injectMembers(mainActivity);
    }

    @Override
    public void inject(ArticleActivity articleActivity) {
      articleActivityMembersInjector.injectMembers(articleActivity);
    }

    @Override
    public void inject(LoginActivity loginActivity) {
      loginActivityMembersInjector.injectMembers(loginActivity);
    }

    @Override
    public void inject(AnswersActivity answersActivity) {
      MembersInjectors.<AnswersActivity>noOp().injectMembers(answersActivity);
    }

    @Override
    public void inject(ArticleDetailActivity articleDetailActivity) {
      MembersInjectors.<ArticleDetailActivity>noOp().injectMembers(articleDetailActivity);
    }

    @Override
    public void inject(EditDataActivity editDataActivity) {
      MembersInjectors.<EditDataActivity>noOp().injectMembers(editDataActivity);
    }

    @Override
    public void inject(SignUpActivity signUpActivity) {
      signUpActivityMembersInjector.injectMembers(signUpActivity);
    }

    @Override
    public void inject(SplashActivity splashActivity) {
      MembersInjectors.<SplashActivity>noOp().injectMembers(splashActivity);
    }

    @Override
    public FragmentComponent plus(FragmentModule fragmentModule) {
      return new FragmentComponentImpl(fragmentModule);
    }

    private final class FragmentComponentImpl implements FragmentComponent {
      private final FragmentModule fragmentModule;

      private MembersInjector<HomeFPresenterImpl> homeFPresenterImplMembersInjector;

      private Provider<HomeFPresenterImpl> homeFPresenterImplProvider;

      private Provider<HomeFPresenter> provideHomeFPresenterProvider;

      private MembersInjector<HomeFragment> homeFragmentMembersInjector;

      private Provider<PersonalFPresenter> providePersonalFPresenterProvider;

      private MembersInjector<PersonalFragment> personalFragmentMembersInjector;

      private Provider<DiscussionFPresenter> provideDiscussionFPresenterProvider;

      private MembersInjector<DiscussionFragment> discussionFragmentMembersInjector;

      private FragmentComponentImpl(FragmentModule fragmentModule) {
        this.fragmentModule = Preconditions.checkNotNull(fragmentModule);
        initialize();
      }

      @SuppressWarnings("unchecked")
      private void initialize() {

        this.homeFPresenterImplMembersInjector =
            HomeFPresenterImpl_MembersInjector.create(
                DaggerAppComponent.this.provideArticleServiceProvider,
                DaggerAppComponent.this.provideDaoSessionProvider,
                DaggerAppComponent.this.provideExecutorServiceProvider);

        this.homeFPresenterImplProvider =
            HomeFPresenterImpl_Factory.create(homeFPresenterImplMembersInjector);

        this.provideHomeFPresenterProvider =
            FragmentModule_ProvideHomeFPresenterFactory.create(
                fragmentModule, homeFPresenterImplProvider);

        this.homeFragmentMembersInjector =
            HomeFragment_MembersInjector.create(provideHomeFPresenterProvider);

        this.providePersonalFPresenterProvider =
            FragmentModule_ProvidePersonalFPresenterFactory.create(
                fragmentModule, PersonalFPresenterImpl_Factory.create());

        this.personalFragmentMembersInjector =
            PersonalFragment_MembersInjector.create(providePersonalFPresenterProvider);

        this.provideDiscussionFPresenterProvider =
            FragmentModule_ProvideDiscussionFPresenterFactory.create(
                fragmentModule, DiscussionFPresenterImpl_Factory.create());

        this.discussionFragmentMembersInjector =
            DiscussionFragment_MembersInjector.create(provideDiscussionFPresenterProvider);
      }

      @Override
      public void inject(HomeFragment homeFragment) {
        homeFragmentMembersInjector.injectMembers(homeFragment);
      }

      @Override
      public void inject(PersonalFragment personalFragment) {
        personalFragmentMembersInjector.injectMembers(personalFragment);
      }

      @Override
      public void inject(DiscussionFragment discussionFragment) {
        discussionFragmentMembersInjector.injectMembers(discussionFragment);
      }
    }
  }
}
