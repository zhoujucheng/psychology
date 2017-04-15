package com.dt.psychology.ui.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.adapters.FooterAdapter;
import com.dt.psychology.adapters.QuestionRcvAdapter;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.domain.Question;
import com.dt.psychology.presenter.fragments.DiscussionFPresenter;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.activities.AskQuestionActivity;
import com.dt.psychology.ui.views.DiscussionFView;
import com.dt.psychology.util.RecyclerLoadMoreOnScrollListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscussionFragment extends BaseFragment implements DiscussionFView,SwipeRefreshLayout.OnRefreshListener{

    public final static String TAG="DiscussionFragment";

    @BindView(R.id.fragment_discussion_spn_sort)
    Spinner spnSort;
    @BindView(R.id.fragment_discussion_spn_category)
    Spinner spnCategory;
    @BindView(R.id.fragment_discussion_rcv_question)
    RecyclerView rcvQuestion;
    @BindView(R.id.fragment_discussion_srfly)
    SwipeRefreshLayout srfly;
    @BindView(R.id.fragment_discussion_edt_search)
    EditText edtSearch;
    @Inject
    DiscussionFPresenter discussionFPresenter;

    private QuestionRcvAdapter adapter;
    private boolean isFirstInit = true;
    private String keyWords = "";

    public DiscussionFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        Log.e(TAG,"init()");
        discussionFPresenter.attachView(this);
        initSpn();
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().equals("")){
                    adapter.save();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    Log.e(TAG,"onChange");
                    adapter.restore();
                    keyWords = "";
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        discussionFPresenter.init();
        adapter = new QuestionRcvAdapter(new LinkedList<Question>());
        rcvQuestion.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvQuestion.setAdapter(adapter);
        srfly.setOnRefreshListener(this);
        srfly.setRefreshing(true);
        onRefresh();
        rcvQuestion.addOnScrollListener(new RecyclerLoadMoreOnScrollListener() {
            @Override
            public void onLoadMore(int currentPage) {
                Log.e(TAG,"onLoadMore");
                int status = adapter.getFooterStatus();
                if (status == FooterAdapter.FOOTER_LOAD_FAIL || status == FooterAdapter.FOOTER_HIDING){
                    if (srfly.isRefreshing()){
                        adapter.setFooterStatus(FooterAdapter.FOOTER_LOAD_MORE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setFooterStatus(FooterAdapter.FOOTER_HIDING);
                            }
                        },2000);
                    }
                    else if (keyWords.equals(edtSearch.getText().toString())){
                        discussionFPresenter.loadMore(adapter.getQuestions(),keyWords);
                    }else {
                        keyWords = edtSearch.getText().toString();
                        adapter.reset();
                        discussionFPresenter.loadMore(adapter.getQuestions(),keyWords);
                    }
                }
            }
        });
    }

    private void initSpn(){
        ArrayAdapter<CharSequence> spnSortAdapter = ArrayAdapter.createFromResource(getContext(),R.array.category_sort,android.R.layout.simple_spinner_item);
        spnSortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSort.setAdapter(spnSortAdapter);
        List<String> categoryList = new ArrayList<>();
        categoryList.add("全部");
        ArrayAdapter<String> spnCategoryAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,categoryList);
        spnCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory.setAdapter(spnCategoryAdapter);
    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_discussion;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onRefresh() {
        if (adapter.getFooterStatus() == FooterAdapter.FOOTER_LOAD_MORE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    srfly.setRefreshing(false);
                }
            },2000);
            return;
        }
        List<Question> questions = adapter.getQuestions();
        if (keyWords.equals(edtSearch.getText().toString())){
            discussionFPresenter.refresh(questions,keyWords);
        }else {
            keyWords = edtSearch.getText().toString();
            adapter.reset();
            discussionFPresenter.refresh(questions,keyWords);
        }
        Log.e(TAG,"onRefresh,keyWords:"+keyWords);
    }

    @Override
    public void cancelRefresh(){
        srfly.setRefreshing(false);
    }

    @Override
    public void saveAdapterList(){
        adapter.save();
    }

    @Override
    public void addQuestionsAfterTail(List<Question> questions){
        if (questions != null && questions.size()>0){
            adapter.getQuestions().addAll(questions);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addQuestionsBeforeHead(List<Question> questions){
        if (questions != null){
            adapter.getQuestions().addAll(0,questions);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setFooterStatus(int status){
        adapter.setFooterStatus(status);
    }

    @OnClick(R.id.fragment_discussion_iv_search)
    public void searchClick(){
        keyWords = edtSearch.getText().toString();
        Log.e(TAG,"searchClick,keywords:"+keyWords);
        if (!keyWords.equals("")){
            srfly.setRefreshing(true);
            adapter.save();
            discussionFPresenter.refresh(adapter.getQuestions(),keyWords);
        }
    }

    @OnClick(R.id.fragment_discussion_ask_question)
    public void askQuestionClick(){
        if (MyApplication.isNetworkUsable()){
            if (getMyApplication().getUser()!=null){
                startActivity(AskQuestionActivity.class);
            }else {
                showToast(R.string.tip_please_login);
            }
        }else {
            showToast(R.string.network_unavailable);
        }
    }
}
