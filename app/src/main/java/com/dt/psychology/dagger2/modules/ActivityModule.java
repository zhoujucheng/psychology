package com.dt.psychology.dagger2.modules;

import android.app.Activity;
import android.content.Context;

import com.dt.psychology.dagger2.scope.ActivityScope;
import com.dt.psychology.presenter.activitis.ArticlePresenter;
import com.dt.psychology.presenter.activitis.ArticlePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnnt9 on 2017/3/17.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Context provideActivityContext(){
        return mActivity;
    }

    @Provides
    @ActivityScope
    public ArticlePresenter provideArticlePresenterImpl(ArticlePresenterImpl articlePresenter){
        return articlePresenter;
    }
}
