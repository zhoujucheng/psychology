package com.dt.psychology.ui.activities;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dt.psychology.R;
import com.dt.psychology.adapters.ArticleRcvAdapter;
import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Article;
import com.dt.psychology.presenter.activitis.ArticlePresenter;
import com.dt.psychology.ui.views.ArticleView;
import com.dt.psychology.util.RecyclerLoadMoreOnScrollListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ArticleActivity extends BaseSwipeBackActivity
        implements ArticleView,SwipeRefreshLayout.OnRefreshListener{
    public static final String TAG = "ArticleActivity";

    @BindView(R.id.activity_article_rcv)
    RecyclerView rcv;
    @BindView(R.id.activity_article_srfly)
    SwipeRefreshLayout srfly;
    @Inject
    ArticlePresenter articlePresenter;

    private long tagId;
    private ArticleRcvAdapter adapter;

    @Override
    protected void init() {
        articlePresenter.attachView(this);
        tagId = getIntent().getLongExtra("tagId",0);
        articlePresenter.init(tagId);
        adapter = new ArticleRcvAdapter(new LinkedList<Article>());
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
        srfly.setOnRefreshListener(this);
        srfly.setRefreshing(true);
        onRefresh();
        rcv.addOnScrollListener(new RecyclerLoadMoreOnScrollListener() {
            //进入此页面后会自动调用该方法
            @Override
            public void onLoadMore(int currentPage) {
                Log.e(TAG,"onLoadMore()");
                int status = adapter.getFooterStatus();
                //当加载状态不为FOOTER_LOAD_MORE且不为FOOTER_NO_MORE时才加载
                if((status == FooterAdapter.FOOTER_HIDING || status == FooterAdapter.FOOTER_LOAD_FAIL)){
                    //在下拉刷新的同时不可加载更多
                    if (srfly.isRefreshing()){
                        //虚假加载
                        adapter.setFooterStatus(FooterAdapter.FOOTER_LOAD_MORE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            }
                        },2000);
                    }
                    else articlePresenter.loadMore(adapter.getArticles());
                }
            }
        });
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
    public void addArticlesAfterTail(List<Article> articles){
        if (articles != null && articles.size()>0){
            adapter.getArticles().addAll(articles);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addArticlesBeforeHead(List<Article> articles){
        if (articles != null){
            adapter.getArticles().addAll(0,articles);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setFooterStatus(int status){
        adapter.setFooterStatus(status);
    }

    @Override
    public void cancelRefresh(){
        srfly.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        Log.e(TAG,"onRefresh()");
        //在下拉刷新的同时不可加载更多
        if (adapter.getFooterStatus() == FooterAdapter.FOOTER_LOAD_MORE){
            //虚假刷新
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    srfly.setRefreshing(false);
                }
            },2000);
            return;
        }
        List<Article> articles = adapter.getArticles();
        if (articles.size()>0)
            articlePresenter.refresh(articles.get(0).getId());
        else articlePresenter.refresh(-1);
    }
}
