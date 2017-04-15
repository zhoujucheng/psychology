package com.dt.psychology.ui.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Comment;
import com.dt.psychology.domain.Question;

import butterknife.BindView;

public class AnswerDetailActivity extends BaseActivity {

    @BindView(R.id.activity_answer_detail_tv_question)
    TextView tvQuestion;
    @BindView(R.id.activity_answer_detail_tv_answer_author)
    TextView tvAnswerAuthor;
    @BindView(R.id.activity_answer_detail_tv_answer_content)
    TextView tvAnswerContent;

    @Override
    protected void init() {
        Intent intent = getIntent();
        Question question =(Question)intent.getSerializableExtra("question");
        Comment comment = (Comment) intent.getSerializableExtra("answer");
        tvQuestion.setText(question.getContent());
        tvAnswerAuthor.setText(comment.getUser().getAlias());
        tvAnswerContent.setText(comment.getContent());
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {}

    @Override
    protected int getContentView() {
        return R.layout.activity_answer_detail;
    }
}
