package com.dt.psychology.presenter.activitis;

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
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUnavailableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
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

    private AttachArticleTagDao attachDao;
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
        attachDao = articleView.getMyApplication().getDaoSession().getAttachArticleTagDao();
    }

    @Override
    public void refresh(final long articleTopId) {
        Observable.create(new ObservableOnSubscribe<List<Article>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Article>> e) throws Exception {
                List<Article> articles=null;
                if (articleTopId == -1L){
                    articles= articleDao.queryBuilder()
                            .limit(10)
                            .orderDesc(ArticleDao.Properties.Id)
                            .list();
                }
                if (articles == null)   articles = new ArrayList<>();
                e.onNext(articles);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<Article>>() {
                    @Override
                    public void accept(List<Article> articleList) throws Exception {
                        if (articleList.size() > 0) articleView.addArticlesBeforeHead(articleList);
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<List<Article>, ObservableSource<Response<Json<List<Article>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Article>>>> apply(List<Article> articleList) throws Exception {
                        if (!MyApplication.isNetworkUsable())   throw new NetworkUnavailableException();
                        long id = -2;
                        if (articleTopId != -1L)    id = articleTopId;
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
                        final List<Article> articles = json.getObject();
                        if (articles != null && articles.size()>0) {
                            articleView.addArticlesBeforeHead(articles);
                            AsynIORWithTags(articles);
                        }
                        articleView.cancelRefresh();
                    }

                    @Override
                    public void errorMsg(String msg) {
                        articleView.cancelRefresh();
                        if (msg.equals("null")){
                            if (articleTopId != -1L)   articleView.showToast("已经是最新文章了");
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
                        if (articles.size()==0) return;
                        articleView.addArticlesAfterTail(articles);
                        disposable.dispose();
                        articleView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<List<Article>, ObservableSource<Response<Json<List<Article>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Article>>>> apply(List<Article> articles) throws Exception {
                        if (!MyApplication.isNetworkUsable())   throw new NetworkUnavailableException();
                        Map<String,String> map = new HashMap<String, String>();
                        map.put("count","10");
                        map.put("state","0");
                        map.put("articleTagId",String.valueOf(tagId));
                        long id = 0;
                        if (articleList.size()>0)
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
                        List<Article> articles = json.getObject();
                        if (articles!=null && articles.size()>0){
                            articleView.addArticlesAfterTail(articles);
                            articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_HIDING);
                            AsynIORWithTags(articles);
                        }else articleView.setFooterStatus(ArticleRcvAdapter.FOOTER_NO_MORE);
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

    private void AsynIORWithTags(final List<Article> articles){
        es.submit(new Runnable() {
            @Override
            public void run() {
                if (articles==null || articles.size() < 1) return;
                articleDao.insertOrReplaceInTx(articles);
                DaoSession daoSession = articleView.getMyApplication().getDaoSession();
                ArticleTagDao tagDao = daoSession.getArticleTagDao();
                for (Article article : articles){
                    List<ArticleTag> tags =article.getTags();
                    if (tags == null || tags.size()<1)  continue;
                    tagDao.insertOrReplaceInTx(tags);
                    for (ArticleTag tag:tags){
                        if (attachDao.queryBuilder()
                                .where(AttachArticleTagDao.Properties.ArticleId.eq(article.getId()),
                                        AttachArticleTagDao.Properties.ArticleTagId.eq(tag.getArticleTagId()))
                                .unique()!=null){
                            break;
                        }
                        AttachArticleTag attachArticleTag = new AttachArticleTag(null,article.getId(),tag.getArticleTagId());
                        attachDao.insertOrReplace(attachArticleTag);
                    }
                }
            }
        });
    }

    private List<Article> getArticlesByTag(int offset){
        List<AttachArticleTag> attachArticleTags = attachDao.queryBuilder()
                .where(AttachArticleTagDao.Properties.ArticleTagId.eq(tagId))
                .orderDesc(AttachArticleTagDao.Properties.ArticleId)
                .offset(offset)
                .limit(10)
                .list();
        List<Article> articles = new ArrayList<>();
        if (attachArticleTags == null)  return articles;
        for (AttachArticleTag attach:attachArticleTags){
            Article article = articleDao.queryBuilder().where(ArticleDao.Properties.Id.eq(attach.getArticleId())).unique();
            if (article!=null)  articles.add(article);
        }
        return articles;
    }
}
