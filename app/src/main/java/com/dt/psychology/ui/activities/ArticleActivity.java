package com.dt.psychology.ui.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dt.psychology.R;
import com.dt.psychology.adapters.ArticleRcvAdapter;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Article;
import com.dt.psychology.ui.views.ArticleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArticleActivity extends BaseSwipeBackActivity implements ArticleView,SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.activity_article_rcv)
    RecyclerView rcv;

    @Override
    protected void init() {
        List<Article> articleList = new ArrayList<>();
        for (int i =0;i<10;i++){
            Article article = new Article();
            article.setBrief("测试");
            article.setImageUrl("http://article.fd.zol-img.com.cn/t_s500x2000/g1/M07/0C/0D/Cg-4jVOpQWmIVPnYAAHFv0U3gXkAAOjOwAtyyUAAcXX661.jpg");
            articleList.add(article);
        }
        ArticleRcvAdapter adapter = new ArticleRcvAdapter(articleList);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_article;
    }

    @Override
    public void onRefresh() {

    }

}
