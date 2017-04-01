package com.dt.psychology.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.dt.psychology.ui.activities.SignUpActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private int[] sample = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};

    @BindView(R.id.fragment_home_cv)
    CarouselView carouselView;
    @BindView(R.id.fragment_home_iv_push)
    ImageView ivPush;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        carouselView.setPageCount(sample.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(HomeFragment.this).load(sample[position]).into(imageView);
            }
        });
        Glide.with(this).load(R.drawable.img3).into(ivPush);
    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick({R.id.fragment_home_csl_growth,R.id.fragment_home_csl_career,R.id.fragment_home_csl_family,
            R.id.fragment_home_csl_love_marriage,R.id.fragment_home_csl_sex})
    public void categoryClick(){
        startActivity(ArticleActivity.class);
    }

    @OnClick(R.id.fragment_home_csl_social)
    public void signUpClick(){
        startActivity(SignUpActivity.class);
    }

}
