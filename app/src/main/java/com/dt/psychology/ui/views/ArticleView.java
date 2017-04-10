package com.dt.psychology.ui.views;

import com.dt.psychology.domain.Article;

import java.util.List;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public interface ArticleView extends BaseView{
    void addArticlesAfterTail(List<Article> articles);
    void addArticlesBeforeHead(List<Article> articles);
    void cancelRefresh();
    void setFooterStatus(int status);

}
