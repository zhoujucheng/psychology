package com.dt.psychology.ui.activities;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;

public class ArticleDetailActivity extends BaseSwipeBackActivity {

    @Override
    protected void init() {
        ImageView iv = (ImageView)findViewById(R.id.activity_article_detail_iv);
        Glide.with(this).load("abc").placeholder(R.drawable.placeholder).into(iv);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_article_detail;
    }
}
