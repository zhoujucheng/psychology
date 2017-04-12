package com.dt.psychology.presenter.fragments;

import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.domain.AttachQuestionTag;
import com.dt.psychology.domain.AttachQuestionTagDao;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.Question;
import com.dt.psychology.domain.QuestionDao;
import com.dt.psychology.domain.QuestionTag;
import com.dt.psychology.domain.QuestionTagDao;
import com.dt.psychology.network.QAndAService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.DiscussionFView;
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
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class DiscussionFPresenterImpl implements DiscussionFPresenter {

    private QuestionDao questionDao;
    private DiscussionFView discussionFView;
    private Disposable disposable;

    @Inject
    QAndAService qAndAService;
    @Inject
    ExecutorService es;

    @Inject
    DiscussionFPresenterImpl(){}

    @Override
    public void attachView(DiscussionFView view) {
        discussionFView = view;
    }

    @Override
    public void init(){
        questionDao = discussionFView.getMyApplication().getDaoSession().getQuestionDao();
    }

    @Override
    public void loadMore(final List<Question> questionList){
        Observable.create(new ObservableOnSubscribe<List<Question>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Question>> e) throws Exception {
                List<Question> ql = null;
                if (questionList.size()>0)
                    ql = questionDao.queryBuilder()
                            .limit(10)
                            .orderDesc(QuestionDao.Properties.QuestionId)
                            .where(QuestionDao.Properties.QuestionId.lt(questionList.get(questionList.size()-1).getQuestionId()))
                            .list();
                if (ql == null) ql=new ArrayList<>();
                e.onNext(ql);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<Question>>() {
                    @Override
                    public void accept(List<Question> questions) throws Exception {
                        if (questions.size()==0)    return;
                        discussionFView.addQuestionsAfterTail(questions);
                        disposable.dispose();
                        discussionFView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<List<Question>, ObservableSource<Response<Json<List<Question>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Question>>>> apply(List<Question> questions) throws Exception {
                        if (!MyApplication.isNetworkUsable())    throw new NetworkUnavailableException();
                        long id = 0;
                        if (questionList.size()>0) id = questionList.get(questionList.size()-1).getQuestionId();
                        Map<String,String> map = new HashMap<>();
                        map.put("count","10");
                        map.put("status","0");
                        map.put("id",String.valueOf(id-1));
                        return qAndAService.getQuestins(map);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Question>>>() {

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        discussionFView.setFooterStatus(FooterAdapter.FOOTER_LOAD_MORE);
                        DiscussionFPresenterImpl.this.disposable = disposable;
                    }

                    @Override
                    public void onSuccess(Json<List<Question>> listJson) {
                        List<Question> questions = listJson.getObject();
                        if (questions != null && questions.size() > 0){
                            discussionFView.addQuestionsAfterTail(questions);
                            discussionFView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            AsynIORWithTags(questions);
                        }else discussionFView.setFooterStatus(FooterAdapter.FOOTER_NO_MORE);

                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")) {
                            discussionFView.setFooterStatus(FooterAdapter.FOOTER_NO_MORE);
                        } else {
                            discussionFView.setFooterStatus(FooterAdapter.FOOTER_LOAD_FAIL);
                            discussionFView.showToast(msg);
                        }
                    }
                });
    }

    private void AsynIORWithTags(final List<Question> questions){
        es.submit(new Runnable() {
            @Override
            public void run() {
                if (questions == null || questions.size() < 1)  return;
                questionDao.insertOrReplaceInTx(questions);
                DaoSession daoSession = discussionFView.getMyApplication().getDaoSession();
                QuestionTagDao tagDao = daoSession.getQuestionTagDao();
                AttachQuestionTagDao attachDao = daoSession.getAttachQuestionTagDao();
                for (Question question : questions){
                    List<QuestionTag> tags = question.getQuestionTags();
                    if (tags == null || tags.size() < 1)    continue;
                    tagDao.insertOrReplaceInTx(tags);
                    for (QuestionTag tag:tags){
                        if (attachDao.queryBuilder()
                                .where(AttachQuestionTagDao.Properties.QuestionId.eq(question.getQuestionId()),
                                        AttachQuestionTagDao.Properties.QuestionTagId.eq(tag.getQuestionTagId()))
                                .unique() != null){
                            break;
                        }
                        AttachQuestionTag attach = new AttachQuestionTag(null,question.getQuestionId(),tag.getQuestionTagId());
                        attachDao.insertOrReplace(attach);
                    }
                }
            }
        });
    }

    @Override
    public void refresh(final long questionTopId){
        Observable.create(new ObservableOnSubscribe<List<Question>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Question>> e) throws Exception {
                List<Question> ql = null;
                if (questionTopId == -1L)
                    ql = questionDao.queryBuilder()
                            .limit(10)
                            .orderDesc(QuestionDao.Properties.QuestionId)
                            .list();
                if (ql == null) ql = new ArrayList<>();
                e.onNext(ql);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<Question>>() {
                    @Override
                    public void accept(List<Question> questions) throws Exception {
                        if (questions.size() > 0)   discussionFView.addQuestionsBeforeHead(questions);
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<List<Question>, ObservableSource<Response<Json<List<Question>>>>>() {
                    @Override
                    public ObservableSource<Response<Json<List<Question>>>> apply(List<Question> questions) throws Exception {
                        if (!MyApplication.isNetworkUsable())   throw new NetworkUnavailableException();
                        Map<String,String> map = new HashMap<>();
                        long id = -2;
                        if (questionTopId != -1)    id = questionTopId;
                        map.put("id",String.valueOf(id+1));
                        map.put("count","10");
                        map.put("status","1");
                        return qAndAService.getQuestins(map);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Question>>>() {

                    @Override
                    public void onSuccess(Json<List<Question>> listJson) {
                        List<Question> questions = listJson.getObject();
                        if (questions != null && questions.size() > 0){
                            discussionFView.addQuestionsBeforeHead(questions);
                            AsynIORWithTags(questions);
                        }
                        discussionFView.cancelRefresh();
                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")){
                            if (questionTopId != -1) discussionFView.showToast("已是最新数据");
                        }else {
                            discussionFView.showToast(msg);
                        }
                        discussionFView.cancelRefresh();
                    }
                });
    }
}
