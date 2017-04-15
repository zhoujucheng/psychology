package com.dt.psychology.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.adapters.AnswerRcvAdapter;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Comment;
import com.dt.psychology.domain.Question;
import com.dt.psychology.domain.QuestionTag;
import com.dt.psychology.presenter.activitis.AnswerPresenter;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.AnswersView;
import com.dt.psychology.util.RecyclerLoadMoreOnScrollListener;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class AnswersActivity extends BaseSwipeBackActivity implements AnswersView{

    @BindView(R.id.activity_answer_tv_question_author_time)
    TextView tvAuthorTime;
    @BindView(R.id.activity_answer_tv_question_title)
    TextView tvTitle;
    @BindView(R.id.activity_answer_tv_question_content)
    TextView tvContent;
    @BindView(R.id.activity_answer_tv_question_tag)
    TextView tvTag;
    @BindView(R.id.activity_answer_tv_question_answer_count)
    TextView tvAnswerCount;
    @BindView(R.id.activity_answer_rcv)
    RecyclerView rcv;
    @Inject
    AnswerPresenter answerPresenter;

    private AnswerRcvAdapter adapter;

    @Override
    protected void init() {
        answerPresenter.attachView(this);
        final Question question = (Question)getIntent().getSerializableExtra("question");
        adapter = new AnswerRcvAdapter(new LinkedList<Comment>());
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
        rcv.addOnScrollListener(new RecyclerLoadMoreOnScrollListener() {
            @Override
            public void onLoadMore(int currentPage) {
                List<Comment> comments = adapter.getComments();
                if (comments.size() == 0)  answerPresenter.getAnswers(question.getQuestionId(),-1);
                else answerPresenter.getAnswers(question.getQuestionId(),comments.get(comments.size()-1).getCommentId());
            }
        });
        answerPresenter.getAnswers(question.getQuestionId(),-1);
        initQuestion(question);
        adapter.setQuestion(question);
    }

    private void initQuestion(Question question){
        tvAuthorTime.setText(question.getUser().getAlias());
        tvTitle.setText(question.getTitle());
        tvContent.setText(question.getContent());
        tvAnswerCount.setText(String.valueOf(question.getAplyCount()));
        if (question.getQuestionTags()!=null){
            for (QuestionTag tag : question.getQuestionTags())
                tvTag.append(tag.getQuestionTagName()+" ");
        }
    }

    @Override
    public void setAdapterStatus(int status){
        adapter.setFooterStatus(status);
    }

    @Override
    public void addCommentsAfterTail(List<Comment> comments){
        adapter.addListAfterTail(comments);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_answers;
    }

    @OnClick(R.id.activity_answer_fabtn_write_answer)
    public void writeAnswerClick(){
        if (MyApplication.isNetworkUsable()){
            if (getMyApplication().getUser()!=null){
                startActivity(WriteCommentActivity.class);
            }else {
                showToast(R.string.tip_please_login);
            }
        }else {
            showToast(R.string.network_unavailable);
        }
    }
}
