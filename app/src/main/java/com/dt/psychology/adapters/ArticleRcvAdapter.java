package com.dt.psychology.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.domain.Article;
import com.dt.psychology.ui.activities.ArticleDetailActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dnnt9 on 2017/3/22.
 */

public class ArticleRcvAdapter extends FooterAdapter<ArticleRcvAdapter.ArticleItemHolder> {

    private List<Article> articles;

    public ArticleRcvAdapter(List<Article> articles){
        if (articles == null) articles = new ArrayList<>();
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public int getItemCount() {
        return articles.size()+1;
    }

    @Override
    public ArticleItemHolder getViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_rcv_item,parent,false);
        return new ArticleItemHolder(view);
    }

    @Override
    public void itemBindViewHolder(ArticleItemHolder holder, int position) {
        final Article article = articles.get(position);
        ImageView iv = holder.iv;
        holder.tv.setText(String.valueOf(article.getId()));
        holder.tv.append(article.getContent());
        Glide.with(iv.getContext()).load(article.getImagesUrl()).placeholder(R.drawable.placeholder).into(iv);
        holder.csl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,ArticleDetailActivity.class);
                intent.putExtra("article",article);
                context.startActivity(intent);
            }
        });
    }

    class ArticleItemHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tv;
        private ConstraintLayout csl;
        public ArticleItemHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.article_rcv_item_iv);
            tv = (TextView)itemView.findViewById(R.id.article_rcv_item_tv);
            csl = (ConstraintLayout)itemView.findViewById(R.id.article_rcv_item_csl);
        }
    }
}
