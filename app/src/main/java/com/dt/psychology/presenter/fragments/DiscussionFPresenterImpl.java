package com.dt.psychology.presenter.fragments;

import com.dt.psychology.R;
import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.Question;
import com.dt.psychology.network.QAndAService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.DiscussionFView;
import com.dt.psychology.util.MyObserver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by dnnt9 on 2017/4/5.
 */

public class DiscussionFPresenterImpl implements DiscussionFPresenter {

    public static final int LOAD_MORE_FLAG = 0;
    public static final int REFRESH_FLAG = 1;

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
    public void init(){}

    @Override
    public void loadMore(final List<Question> questionList,String keyWords){
        long id = 0;
        if (questionList != null && questionList.size()>0)
             id = questionList.get(questionList.size()-1).getQuestionId();
        questionsFromServer(id,keyWords,LOAD_MORE_FLAG);
    }

    private void questionsFromServer(long id, String keyWords, final int flag){
        if (!MyApplication.isNetworkUsable())    {
            discussionFView.showToast(R.string.network_unavailable);
            if (flag == LOAD_MORE_FLAG) discussionFView.setFooterStatus(FooterAdapter.FOOTER_LOAD_FAIL);
            else discussionFView.cancelRefresh();
            return;
        }
        Map<String,String> map = new HashMap<>();
        map.put("count","10");
        map.put("state",String.valueOf(flag));
        map.put("keyWords",keyWords);
        if (flag == LOAD_MORE_FLAG){
            map.put("id",String.valueOf(id-1));
            discussionFView.setFooterStatus(FooterAdapter.FOOTER_LOAD_MORE);
        } else {
            map.put("id", String.valueOf(id + 1));
            discussionFView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
        }
        qAndAService.getQuestions(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Question>>>() {
                    @Override
                    public void onSuccess(Json<List<Question>> listJson) {
                        List<Question> questions = listJson.getObject();
                        if (questions!=null && questions.size()>0){
                            if (flag == LOAD_MORE_FLAG){
                                discussionFView.addQuestionsAfterTail(questions);
                                discussionFView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            } else{
                                discussionFView.addQuestionsBeforeHead(questions);
                                discussionFView.cancelRefresh();
                            }
                        }else {
                            discussionFView.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            discussionFView.cancelRefresh();
                        }

                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")){
                            if (flag == LOAD_MORE_FLAG) discussionFView.setFooterStatus(FooterAdapter.FOOTER_NO_MORE);
                            else{
                                discussionFView.showToast("无更多相关问题");
                                discussionFView.cancelRefresh();
                            }
                        }else {
                            if (flag == LOAD_MORE_FLAG) discussionFView.setFooterStatus(FooterAdapter.FOOTER_LOAD_FAIL);
                            else{
                                discussionFView.showToast(msg);
                                discussionFView.cancelRefresh();
                            }
                        }
                    }
                });
    }

    @Override
    public void refresh(List<Question> questions,String keyWords){
        long id = -2;
        if (questions != null && questions.size()>0)
            id = questions.get(0).getQuestionId();
        questionsFromServer(id,keyWords,REFRESH_FLAG);
    }
}
