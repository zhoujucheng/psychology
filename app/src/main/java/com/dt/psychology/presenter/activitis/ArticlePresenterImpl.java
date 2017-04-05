package com.dt.psychology.presenter.activitis;

import android.content.Context;
import android.util.Log;
import com.dt.psychology.ui.views.ArticleView;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public class ArticlePresenterImpl implements ArticlePresenter {
    @Inject
    Context context;

    private ArticleView articleView;

    @Inject
    public ArticlePresenterImpl(){}

    @Override
    public void test() {
        Log.e("ArticleContext",context.toString());
//        articleView.showToast(context.toString());
    }

    @Override
    public void attachView(ArticleView view) {
        articleView = view;
    }
}
