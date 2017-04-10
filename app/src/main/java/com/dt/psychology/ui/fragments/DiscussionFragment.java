package com.dt.psychology.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.adapters.QuestionRcvAdapter;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.domain.Question;
import com.dt.psychology.presenter.fragments.DiscussionFPresenter;
import com.dt.psychology.presenter.fragments.PersonalFPresenter;
import com.dt.psychology.ui.views.DiscussionFView;
import com.dt.psychology.util.RecyclerLoadMoreOnScrollListener;

import java.util.ArrayList;
import java.util.Date;
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
    @Inject
    DiscussionFPresenter discussionFPresenter;

    private QuestionRcvAdapter adapter;

    public DiscussionFragment() {
        // Required empty public constructor
    }


    @Override
    void init() {
        initSpn();
        srfly.setOnRefreshListener(this);
        List<Question> questions = new ArrayList<>();
        for (int i = 0;i<10;i++){
            Question question = new Question();
            question.setUserId(1L);
            question.setContent("sdsefwefafasdfsdcsada");
            question.setTitle("sdfese");
            question.setCreateTime(new Date(System.currentTimeMillis()));
            questions.add(question);
        }
        adapter = new QuestionRcvAdapter(questions);
        rcvQuestion.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvQuestion.setAdapter(adapter);
        rcvQuestion.addOnScrollListener(new RecyclerLoadMoreOnScrollListener() {
            @Override
            public void onLoadMore(int currentPage) {
                Log.e(TAG,"onLoadMore");
            }
        });
    }

    private void initSpn(){
        discussionFPresenter.attachView(this);
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

    }
}
