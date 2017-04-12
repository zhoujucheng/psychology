package com.dt.psychology.presenter.fragments;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.dt.psychology.R;
import com.dt.psychology.domain.Article;
import com.dt.psychology.domain.ArticleDao;
import com.dt.psychology.domain.ArticleTag;
import com.dt.psychology.domain.ArticleTagDao;
import com.dt.psychology.domain.AttachArticleTag;
import com.dt.psychology.domain.AttachArticleTagDao;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.domain.Json;
import com.dt.psychology.network.ArticleService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.HomeFView;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUnavailableException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.IntFunction;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class HomeFPresenterImpl implements HomeFPresenter {

    private HomeFView homeFView;

    @Inject
    ArticleService articleService;
    @Inject
    DaoSession daoSession;
    @Inject
    ExecutorService es;

    @Inject
    public HomeFPresenterImpl(){}

    public String Tag = "HomeFPresenter";

    @Override
    public void attachView(HomeFView view) {
        homeFView = view;
    }

    @Override
    public void init() {
        Observable.create(new ObservableOnSubscribe<Article>() {
            @Override
            public void subscribe(ObservableEmitter<Article> e) throws Exception {
                ArticleDao articleDao = daoSession.getArticleDao();
                Article article = articleDao.queryBuilder()
                        .orderDesc(ArticleDao.Properties.Id)
                        .limit(1)
                        .unique();
                if (article == null) article = new Article();
                e.onNext(article);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Article>() {
                    @Override
                    public void accept(Article article) throws Exception {
                        if (article.getId() != null) homeFView.setPushArticle(article);
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<Article, ObservableSource<Response<Json<List<Article>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Article>>>> apply(Article article) throws Exception {
                        if (!MyApplication.isNetworkUsable())   throw new NetworkUnavailableException();
                        long id = -2;
                        if (article.getId() != null)    id = article.getId();
                        Map<String,String> map = new HashMap<>();
                        map.put("state","1");
                        map.put("id",String.valueOf(id+1));
                        map.put("count","10");
                        map.put("articleTagId","1");
                        return articleService.getArticles(map);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Article>>>() {
                    @Override
                    public void onSuccess(Json<List<Article>> json) {
                        final List<Article> articles = json.getObject();
                        if (articles == null || articles.size() < 1)    return;
                        for (Article article:articles){
                            if (article.getContent()!=null)
                            Log.e(Tag,article.getContent());
                        }
                        homeFView.setPushArticle(articles.get(0));
                        es.submit(new Runnable() {
                            @Override
                            public void run() {
                                ArticleDao articleDao = daoSession.getArticleDao();
                                articleDao.insertOrReplaceInTx(articles);
                                if (articles == null || articles.size()<1)  return;
                                ArticleTagDao tagDao = homeFView.getMyApplication().getDaoSession().getArticleTagDao();
                                AttachArticleTagDao dao = homeFView.getMyApplication().getDaoSession().getAttachArticleTagDao();
                                for (int i=0;i<articles.size();i++){
                                    Article article = articles.get(i);
                                    List<ArticleTag> tags =article.getTags();
                                    Log.e("insertTag","insert");
                                    if (tags == null || tags.size()<1)  continue;
                                    tagDao.insertOrReplaceInTx(tags);
                                    if (dao.queryBuilder()
                                            .where(AttachArticleTagDao.Properties.ArticleId.eq(article.getId()),
                                                    AttachArticleTagDao.Properties.ArticleTagId.eq(tags.get(0).getArticleTagId()))
                                            .unique()!=null){
                                        continue;
                                    }
                                    for (int j=0;j<tags.size();j++){
                                        AttachArticleTag attachArticleTag = new AttachArticleTag(null,article.getId(),tags.get(j).getArticleTagId());
                                        dao.insertOrReplace(attachArticleTag);
                                    }
                                }
                            }
                        });
                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (!msg.equals("null"))
                            homeFView.showToast(msg);
                    }
                });
    }
}
