package com.dt.psychology.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.domain.Article;
import com.dt.psychology.domain.ArticleTag;
import com.dt.psychology.domain.ArticleTagDao;
import com.dt.psychology.presenter.fragments.HomeFPresenter;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.dt.psychology.ui.views.HomeFView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeFView{

    private static final String TAG = "HomeFragment";

    @BindView(R.id.fragment_home_cv)
    CarouselView carouselView;
    @BindView(R.id.fragment_home_tv_push_brief)
    TextView tvBrief;
    @BindView(R.id.fragment_home_tv_page_view)
    TextView tvPageView;
    @BindView(R.id.fragment_home_iv_push)
    ImageView ivPush;
    @Inject
    HomeFPresenter homeFPresenter;

    private boolean isFirstInit = true;
    private Article pushArticle;
    private int[] sample = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        Log.e(TAG,"init()");
        homeFPresenter.attachView(this);
        carouselView.setPageCount(sample.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(HomeFragment.this).load(sample[position]).into(imageView);
            }
        });
        Glide.with(this).load(R.drawable.placeholder).into(ivPush);
        if (pushArticle!=null)  setPushArticle(pushArticle);
        if (isFirstInit){
            homeFPresenter.init();
            isFirstInit = false;
        }
    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick({R.id.fragment_home_csl_growth,R.id.fragment_home_csl_social,R.id.fragment_home_csl_career,R.id.fragment_home_csl_family,
            R.id.fragment_home_csl_love_marriage,R.id.fragment_home_csl_sex})
    public void categoryClick(View view){
        long tagId = 1L;
        switch (view.getId()){
            case R.id.fragment_home_csl_growth:
//                tagId = getTagId("personalGrowth");
                tagId = 1;
                break;
            case R.id.fragment_home_csl_social:
//                tagId = getTagId("peopleSkills");
                tagId = 2;
                break;
            case R.id.fragment_home_csl_sex:
//                tagId = getTagId("psychologicalSurname");
                tagId = 3;
                break;
            case R.id.fragment_home_csl_love_marriage:
//                tagId = getTagId("marriage");
                tagId = 4;
                break;
            case R.id.fragment_home_csl_family:
//                tagId = getTagId("familyRelations");
                tagId = 5;
                break;
            case R.id.fragment_home_csl_career:
//                tagId = getTagId("workPlace");
                tagId = 6;
                break;
        }
        Intent intent =new Intent(getContext(),ArticleActivity.class);
        intent.putExtra("tagId",tagId);
        startActivity(intent);
    }

//    public long getTagId(String tagName){
//        ArticleTagDao articleTagDao = getMyApplication().getDaoSession().getArticleTagDao();
//        ArticleTag tag = articleTagDao.queryBuilder()
//                .where(ArticleTagDao.Properties.ArticleTagName.eq(tagName))
//                .unique();
//        if (tag != null)  return tag.getArticleTagId();
//        return 0;
//    }

    @Override
    public void setPushArticle(Article article){
        tvBrief.setText(article.getContent());
        Glide.with(this).load(article.getImagesUrl()).placeholder(R.drawable.placeholder).into(ivPush);
        pushArticle = article;
    }
}
