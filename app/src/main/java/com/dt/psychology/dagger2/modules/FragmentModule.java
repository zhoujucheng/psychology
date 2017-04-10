package com.dt.psychology.dagger2.modules;

import com.dt.psychology.presenter.fragments.DiscussionFPresenter;
import com.dt.psychology.presenter.fragments.DiscussionFPresenterImpl;
import com.dt.psychology.presenter.fragments.HomeFPresenter;
import com.dt.psychology.presenter.fragments.HomeFPresenterImpl;
import com.dt.psychology.presenter.fragments.PersonalFPresenter;
import com.dt.psychology.presenter.fragments.PersonalFPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnnt9 on 2017/3/18.
 */

@Module
public class FragmentModule {

    @Provides
    public HomeFPresenter provideHomeFPresenter(HomeFPresenterImpl homeFPresenter){
        return homeFPresenter;
    }

    @Provides
    DiscussionFPresenter provideDiscussionFPresenter(DiscussionFPresenterImpl discussionFPresenter){
        return  discussionFPresenter;
    }

    @Provides
    PersonalFPresenter providePersonalFPresenter(PersonalFPresenterImpl personalFPresenter){
        return personalFPresenter;
    }
}
