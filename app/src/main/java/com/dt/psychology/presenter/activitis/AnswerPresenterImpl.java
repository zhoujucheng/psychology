package com.dt.psychology.presenter.activitis;

import com.dt.psychology.R;
import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.domain.Comment;
import com.dt.psychology.domain.Json;
import com.dt.psychology.network.QAndAService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.AnswersView;
import com.dt.psychology.util.MyObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dnnt9 on 2017/4/14.
 */

public class AnswerPresenterImpl implements AnswerPresenter {

    @Inject
    QAndAService qAndAService;

    private AnswersView answersView ;

    @Inject
    public AnswerPresenterImpl(){}

    @Override
    public void attachView(AnswersView view) {
        answersView = view;
    }

    @Override
    public void getAnswers(long questionId, long answerId) {
        if (!MyApplication.isNetworkUsable()){
            answersView.showToast(R.string.network_unavailable);
            return;
        }
        answersView.setAdapterStatus(FooterAdapter.FOOTER_LOAD_MORE);
        Map<String,Long> map = new HashMap<>();
        map.put("questionId",questionId);
        map.put("commentId",answerId);
        qAndAService.getComments(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Json<List<Comment>>>() {
                    @Override
                    public void onSuccess(Json<List<Comment>> listJson) {
                        List<Comment> comments = listJson.getObject();
                        if (comments!=null && comments.size()>0){
                            answersView.addCommentsAfterTail(comments);
                        }
                        answersView.setAdapterStatus(FooterAdapter.FOOTER_HIDING);
                    }

                    @Override
                    public void errorMsg(String msg) {
                        if (msg.equals("null")){
                            answersView.setAdapterStatus(FooterAdapter.FOOTER_NO_MORE);
                        }else {
                            answersView.setAdapterStatus(FooterAdapter.FOOTER_LOAD_FAIL);
                        }
                    }
                });
    }
}
