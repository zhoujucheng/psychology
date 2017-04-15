package com.dt.psychology.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.domain.Comment;
import com.dt.psychology.domain.Question;
import com.dt.psychology.ui.activities.AnswerDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnnt9 on 2017/4/4.
 */

public class AnswerRcvAdapter extends FooterAdapter<AnswerRcvAdapter.AnswerItemHolder> {

    private List<Comment> comments;
    private Question question;

    public AnswerRcvAdapter(List<Comment> comments){
        if (comments == null) comments = new ArrayList<>();
        this.comments = comments;
    }

    public void setQuestion(Question question){
        this.question = question;
    }

    @Override
    public AnswerItemHolder getViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_rcv_item,parent,false);
        return new AnswerItemHolder(view);
    }

    @Override
    public void itemBindViewHolder(AnswerItemHolder holder, int position) {
        final Comment comment = comments.get(position);
        holder.tvAuthorTime.setText(comment.getUser().getAlias());
        holder.tvContent.setText(comment.getContent());
        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AnswerDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("question",question);
                bundle.putSerializable("answer",comment);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comments.size()+1;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addListAfterTail(List<Comment> comments){
        this.comments.addAll(comments);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        },50);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    class AnswerItemHolder extends RecyclerView.ViewHolder{
        private TextView tvAuthorTime;
        private TextView tvContent;
        public AnswerItemHolder(View itemView) {
            super(itemView);
            tvAuthorTime = (TextView)itemView.findViewById(R.id.answer_rcv_item_tv_author_time);
            tvContent = (TextView)itemView.findViewById(R.id.answer_rcv_item_tv_content);
        }
    }
}
