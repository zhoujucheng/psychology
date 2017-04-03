package com.dt.psychology.dagger2.components;

import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.dagger2.scope.ActivityScope;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.dt.psychology.ui.activities.LoginActivity;
import com.dt.psychology.ui.activities.MainActivity;

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
}
