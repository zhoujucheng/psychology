package com.dt.psychology.presenter.activitis;

import com.dt.psychology.domain.Article;
import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.ui.views.ArticleView;

import java.util.List;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public interface ArticlePresenter extends BasePresenter<ArticleView>{
    void refresh(long id);
    void loadMore(List<Article> articleList);
    void init(long tagId);
}
