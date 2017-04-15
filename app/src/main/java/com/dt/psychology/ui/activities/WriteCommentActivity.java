package com.dt.psychology.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.presenter.activitis.WriteCommentPresenter;
import com.dt.psychology.ui.views.WriteCommentView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class WriteCommentActivity extends BaseActivity implements WriteCommentView{

    @BindView(R.id.activity_write_comment_edt_answer)
    EditText edtAnswer;
    @Inject
    WriteCommentPresenter writeCommentPresenter;

    @Override
    protected void init() {
        writeCommentPresenter.attachView(this);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_write_comment;
    }

    @OnClick(R.id.activity_write_coment_btn_commit)
    public void commitClick(){

    }
}
