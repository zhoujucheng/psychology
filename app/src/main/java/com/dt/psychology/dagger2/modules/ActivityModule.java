package com.dt.psychology.dagger2.modules;

import android.app.Activity;
import android.content.Context;

import com.dt.psychology.dagger2.scope.ActivityScope;
import com.dt.psychology.domain.ArticleDao;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.presenter.activitis.AnswerPresenter;
import com.dt.psychology.presenter.activitis.AnswerPresenterImpl;
import com.dt.psychology.presenter.activitis.ArticlePresenter;
import com.dt.psychology.presenter.activitis.ArticlePresenterImpl;
import com.dt.psychology.presenter.activitis.AskQuestionPresenter;
import com.dt.psychology.presenter.activitis.AskQuestionPresenterImpl;
import com.dt.psychology.presenter.activitis.LoginPresenter;
import com.dt.psychology.presenter.activitis.LoginPresenterImpl;
import com.dt.psychology.presenter.activitis.SignUpPresenter;
import com.dt.psychology.presenter.activitis.SignUpPresenterImpl;
import com.dt.psychology.presenter.activitis.WriteCommentPresenter;
import com.dt.psychology.presenter.activitis.WriteCommentPresenterImpl;

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

    @Provides
    @ActivityScope
    public LoginPresenter provideLoginPresenterImpl(LoginPresenterImpl loginPresenter){
        return loginPresenter;
    }

    @Provides
    @ActivityScope
    public SignUpPresenter provideSignUpPresenterImpl(SignUpPresenterImpl signUpPresenter){
        return  signUpPresenter;
    }

    @Provides
    @ActivityScope
    public AnswerPresenter provideAnswerPresenterImpl(AnswerPresenterImpl answerPresenter){
        return answerPresenter;
    }

    @Provides
    @ActivityScope
    public ArticleDao provideArticleDao(DaoSession daoSession){
        return daoSession.getArticleDao();
    }

    @Provides
    @ActivityScope
    public AskQuestionPresenter provideAskQuestionPresenterImpl(AskQuestionPresenterImpl askQuestionPresenter){
        return askQuestionPresenter;
    }

    @Provides
    @ActivityScope
    public WriteCommentPresenter provideWriteCommentPresenterImpl(WriteCommentPresenterImpl writeCommentPresenter){
        return writeCommentPresenter;
    }
}
