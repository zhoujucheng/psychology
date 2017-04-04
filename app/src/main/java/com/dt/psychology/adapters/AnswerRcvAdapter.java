package com.dt.psychology.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.domain.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnnt9 on 2017/4/4.
 */

public class AnswerRcvAdapter extends RecyclerView.Adapter<AnswerRcvAdapter.AnswerItemHolder> {

    private List<Comment> comments;

    public AnswerRcvAdapter(List<Comment> comments){
        if (comments == null) comments = new ArrayList<>();
        this.comments = comments;
    }

    @Override
    public AnswerItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_rcv_item,parent,false);
        return new AnswerItemHolder(view);
    }

    @Override
    public void onBindViewHolder(AnswerItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return comments.size();
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
