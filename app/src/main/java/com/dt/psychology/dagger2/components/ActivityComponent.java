package com.dt.psychology.dagger2.components;

import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.dagger2.scope.ActivityScope;
import com.dt.psychology.ui.activities.AnswersActivity;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.dt.psychology.ui.activities.ArticleDetailActivity;
import com.dt.psychology.ui.activities.EditDataActivity;
import com.dt.psychology.ui.activities.LoginActivity;
import com.dt.psychology.ui.activities.MainActivity;
import com.dt.psychology.ui.activities.SignUpActivity;
import com.dt.psychology.ui.activities.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by dnnt9 on 2017/3/17.
 */

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    FragmentComponent plus(FragmentModule fragmentModule);
    void inject(MainActivity mainActivity);
    void inject(ArticleActivity articleActivity);
    void inject(LoginActivity loginActivity);
    void inject(AnswersActivity answersActivity);
    void inject(ArticleDetailActivity articleDetailActivity);
    void inject(EditDataActivity editDataActivity);
    void inject(SignUpActivity signUpActivity);
    void inject(SplashActivity splashActivity);
}
