package com.dt.psychology.adapters;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;

/**
 * Created by dnnt9 on 2017/3/22.
 */

public class ArticleRcvAdapter extends RecyclerView.Adapter<ArticleRcvAdapter.ArticleItemViewHolder> {

    private List<Article> articles;

    public ArticleRcvAdapter(List<Article> articles){
        if (articles == null) articles = new ArrayList<>();
        this.articles = articles;
    }

    @Override
    public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_rcv_item,parent,false);
        return new ArticleItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleItemViewHolder holder, int position) {
        Article article = articles.get(position);
        ImageView iv = holder.iv;
        Glide.with(iv.getContext()).load("abc").placeholder(R.drawable.placeholder).into(iv);
        holder.csl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), ArticleDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ArticleItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tv;
        private ConstraintLayout csl;
        public ArticleItemViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.article_rcv_item_iv);
            tv = (TextView)itemView.findViewById(R.id.article_rcv_item_tv);
            csl = (ConstraintLayout)itemView.findViewById(R.id.article_rcv_item_csl);
        }
    }
}
