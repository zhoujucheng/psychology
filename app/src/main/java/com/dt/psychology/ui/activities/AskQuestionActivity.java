package com.dt.psychology.ui.activities;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.presenter.activitis.AskQuestionPresenter;
import com.dt.psychology.ui.views.AskQuestionView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class AskQuestionActivity extends BaseActivity implements AskQuestionView{

    @BindView(R.id.activity_ask_question_edt_question)
    EditText edtQuestion;
    @BindView(R.id.activity_ask_question_edt_detail)
    EditText edtDetail;
    @BindView(R.id.activity_ask_question_spn_tag)
    Spinner spnTag;
    @Inject
    AskQuestionPresenter askQuestionPresenter;

    @Override
    protected void init() {
        askQuestionPresenter.attachView(this);
//        ArrayAdapter<C>
//        ArrayAdapter<CharSequence> spnSortAdapter = ArrayAdapter.createFromResource(getContext(),R.array.category_sort,android.R.layout.simple_spinner_item);
//        spnSortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spnSort.setAdapter(spnSortAdapter);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_ask_question;
    }

    @OnClick(R.id.activity_ask_question_btn_commit)
    public void commitClick(){

    }
}
