package com.dt.psychology.ui.activities;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.domain.Article;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class ArticleDetailActivity extends BaseSwipeBackActivity {

    @BindView(R.id.activity_article_detail_tv_content)
    TextView tvContent;
    @BindView(R.id.activity_article_detail_tv_title)
    TextView tvTitle;
    @BindView(R.id.activity_article_detail_iv)
    ImageView iv;
    @BindView(R.id.activity_article_detail_tv_author_time)
    TextView tvAuthorTime;

    @Override
    protected void init() {
        Article article =(Article) getIntent().getSerializableExtra("article");
        Glide.with(this).load(article.getImagesUrl()).placeholder(R.drawable.placeholder).into(iv);
        tvTitle.setText(article.getTitle());
        tvContent.setText(article.getContent());
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd hh:mm");
        tvAuthorTime.setText(article.getAuthor()+"    "+dateFormat.format(article.getPublishTime()));
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
