package com.dt.psychology.presenter.activitis;

import android.content.Context;

import com.dt.psychology.R;
import com.dt.psychology.adapters.ArticleRcvAdapter;
import com.dt.psychology.adapters.FooterAdapter;
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
import com.dt.psychology.ui.views.ArticleView;
import com.dt.psychology.util.MyFunction;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUnavailableException;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public class ArticlePresenterImpl implements ArticlePresenter {
    public static final String TAG = "ArticlePresenter";
    @Inject
    ArticleService articleService;
    @Inject
    ExecutorService es;
    @Inject
    ArticleDao articleDao;

    private AttachArticleTagDao attachArticleTagDao;
    private ArticleView articleView;
    private Disposable disposable;
    private long tagId;

    @Inject
    public ArticlePresenterImpl(){}

    @Override
    public void attachView(ArticleView view) {
        articleView = view;
    }

    @Override
    public void init(long articleTagId) {
        this.tagId = articleTagId;
        attachArticleTagDao = articleView.getMyApplication().getDaoSession().getAttachArticleTagDao();
    }

    @Override
    public void refresh(final long articleId) {
        Observable.create(new ObservableOnSubscribe<Article>() {
            @Override
            public void subscribe(ObservableEmitter<Article> e) throws Exception {
//                List<Article> articles = articleDao.queryBuilder()
//                        .where(ArticleDao.Properties.Id.le(articleId))
//                        .limit(10)
//                        .orderDesc(ArticleDao.Properties.Id)
//                        .list();
//                if (articles == null)   articles = new ArrayList<>();
                Article article = articleDao.queryBuilder()
                        .where(ArticleDao.Properties.Id.eq(articleId))
                        .unique();
                if (article == null)    article = new Article();
                e.onNext(article);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
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
                        map.put("articleTagId",String.valueOf(tagId));
                        return articleService.getArticles(map);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Article>>>() {
                    @Override
                    public void onSuccess(Json<List<Article>> json) {
                        handleRefreshArticles(json);
                        articleView.cancelRefresh();
                    }

                    @Override
                    public void errorMsg(String msg) {
                        articleView.cancelRefresh();
                        if (msg.equals("null")){
                            articleView.showToast("已经是最新文章了");
                        }else {
                            articleView.showToast(msg);
                        }
                    }
                });

    }

    @Override
    public void loadMore(final List<Article> articleList) {
        Observable.create(new ObservableOnSubscribe<List<Article>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Article>> e) throws Exception {
                List<Article> articles=getArticlesByTag(articleList.size());
                e.onNext(articles);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<Article>>() {
                    @Override
                    public void accept(List<Article> articles) throws Exception {
                        if (articles!=null&&articles.size()>0){
                            articleView.addArticlesAfterTail(articles);
                            if (articles.size() == 10){
                                disposable.dispose();
                                articleView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            }
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<List<Article>, ObservableSource<Response<Json<List<Article>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Article>>>> apply(List<Article> articles) throws Exception {
                        Map<String,String> map = new HashMap<String, String>();
                        map.put("count","10");
                        map.put("state","0");
                        map.put("articleTagId",String.valueOf(tagId));
                        long id = 0;
                        if (articles!=null&&articles.size()>0&&articleList.size()>0)
                            id = articleList.get(articleList.size()-1).getId();
                        map.put("id",String.valueOf(id-1));
                        return articleService.getArticles(map);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Article>>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_LOAD_MORE);
                        ArticlePresenterImpl.this.disposable = disposable;
                    }

                    @Override
                    public void onSuccess(Json<List<Article>> json) {
                        final List<Article> articles = json.getObject();
                        if (articles!=null&&articles.size()>0){
                            articleView.addArticlesAfterTail(articles);
                            es.submit(new Runnable() {
                                @Override
                                public void run() {
                                    articleDao.insertOrReplaceInTx(articles);
                                }
                            });
                        }
                        articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_HIDING);
                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")){
                            articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_NO_MORE);
                        }else {
                            articleView.showToast(msg);
                            articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_LOAD_FAIL);
                        }
                    }
                });
    }

    private void handleRefreshArticles(Json<List<Article>> json){
        final List<Article> articles = json.getObject();
        if (articles == null || articles.size()<1)  return;
        articleView.addArticlesBeforeHead(articles);
        es.submit(new Runnable() {
            @Override
            public void run() {
                articleDao.insertOrReplaceInTx(articles);
                ArticleTagDao tagDao = articleView.getMyApplication().getDaoSession().getArticleTagDao();
                AttachArticleTagDao dao = articleView.getMyApplication().getDaoSession().getAttachArticleTagDao();
                for (int i=0;i<articles.size();i++){
                    Article article = articles.get(i);
                    List<ArticleTag> tags =article.getTags();
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

    private List<Article> getArticlesByTag(int offset){
        List<AttachArticleTag> attachArticleTags = attachArticleTagDao.queryBuilder()
                .where(AttachArticleTagDao.Properties.ArticleTagId.eq(tagId))
                .orderDesc(AttachArticleTagDao.Properties.ArticleId)
                .offset(offset)
                .limit(10)
                .list();
        List<Article> articles = new ArrayList<>();
        for (int i=0;i<attachArticleTags.size();i++){
            AttachArticleTag attach = attachArticleTags.get(i);
            Article article = articleDao.queryBuilder().where(ArticleDao.Properties.Id.eq(attach.getArticleId())).unique();
            if (article!=null)  articles.add(article);
        }
        return articles;
    }
}
