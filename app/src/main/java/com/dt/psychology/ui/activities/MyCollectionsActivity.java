package com.dt.psychology.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dt.psychology.R;
import com.dt.psychology.adapters.ArticleRcvAdapter;
import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Article;
import com.dt.psychology.domain.Json;
import com.dt.psychology.network.ArticleService;
import com.dt.psychology.network.QAndAService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.RecyclerLoadMoreOnScrollListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyCollectionsActivity extends BaseActivity {

    private static final String TAG = "MyCollectionsActivity";

    @BindView(R.id.activity_my_collections_rcv)
    RecyclerView rcv;
    @Inject
    ArticleService articleService;

    private ArticleRcvAdapter adapter;

    @Override
    protected void init() {
        adapter = new ArticleRcvAdapter(new ArrayList<Article>());
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
        rcv.addOnScrollListener(new RecyclerLoadMoreOnScrollListener() {
            @Override
            public void onLoadMore(int currentPage) {
                Log.e(TAG,"onLoadMore()");
                if (adapter.getFooterStatus() == FooterAdapter.FOOTER_HIDING
                        || adapter.getFooterStatus() == FooterAdapter.FOOTER_LOAD_FAIL){
                    loadMore();
                }
            }
        });
    }

    private void loadMore(){
        if (!MyApplication.isNetworkUsable()){
            showToast(R.string.network_unavailable);
            return;
        }
        adapter.setFooterStatus(FooterAdapter.FOOTER_LOAD_MORE);
        Map<String,String> map = new HashMap<>();
        articleService.getMyCollections(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Article>>>() {
                    @Override
                    public void onSuccess(Json<List<Article>> json) {
                        List<Article> articles = json.getObject();
                        if (articles != null && articles.size()>0){
                            adapter.getArticles().addAll(articles);
                            adapter.notifyDataSetChanged();
                        }
                        adapter.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")){
                            adapter.setFooterStatus(FooterAdapter.FOOTER_NO_MORE);
                        }else {
                            adapter.setFooterStatus(FooterAdapter.FOOTER_LOAD_FAIL);
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
        return R.layout.activity_my_collections;
    }
}
