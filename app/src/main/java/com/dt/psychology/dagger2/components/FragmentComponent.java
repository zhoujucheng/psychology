package com.dt.psychology.dagger2.components;

import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.ui.fragments.HomeFragment;
import com.dt.psychology.ui.fragments.PersonalFragment;

import dagger.Subcomponent;

/**
 * Created by dnnt9 on 2017/3/18.
 */

@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);
    void inject(PersonalFragment personalFragment);
}
