package com.dt.psychology.adapters;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.domain.Question;
import com.dt.psychology.domain.QuestionTag;
import com.dt.psychology.ui.activities.AnswersActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by dnnt9 on 2017/4/3.
 */

public class QuestionRcvAdapter extends FooterAdapter<QuestionRcvAdapter.QuestionItemViewHolder> {

    private List<Question> questions;
    private List<Question> cache;

    public QuestionRcvAdapter(List<Question> questions){
        if (questions == null)  questions = new ArrayList<>();
        this.questions = questions;
        cache = questions;
    }

    public void setQuestions(List<Question> questions){
        this.questions = questions;
        notifyDataSetChanged();
    }

    public void restore(){
        questions = cache;
        notifyDataSetChanged();
    }

    public void reset(){
        questions.clear();
        setFooterStatus(FOOTER_HIDING);
        notifyDataSetChanged();
    }

    public void save(){
        cache = questions;
        questions = new ArrayList<>();
    }

    public List<Question> getQuestions(){
        return questions;
    }

    @Override
    public int getItemCount() {
        return questions.size()+1;
    }

    @Override
    public QuestionItemViewHolder getViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_rcv_item,parent,false);
        return new QuestionItemViewHolder(view);
    }

    @Override
    public void itemBindViewHolder(QuestionItemViewHolder holder, int position) {
        final Question question = questions.get(position);
        holder.tvAuthorTime.setText(question.getUser().getAlias());
        holder.tvContent.setText(question.getContent());
        holder.tvTitle.setText(question.getTitle());
        holder.tvAnswerCount.setText(String.valueOf(question.getAplyCount()));
        if (question.getQuestionTags()!=null){
            for (QuestionTag tag: question.getQuestionTags()){
                holder.tvTag.append(tag.getQuestionTagName()+" ");
            }
        }
        holder.cslQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),AnswersActivity.class);
                intent.putExtra("question",question);
                v.getContext().startActivity(intent);
            }
        });
    }

    class QuestionItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAuthorTime;
        private TextView tvTitle;
        private TextView tvContent;
        private TextView tvTag;
        private TextView tvAnswerCount;
        private ConstraintLayout cslQuestion;
        public QuestionItemViewHolder(View itemView) {
            super(itemView);
            cslQuestion = (ConstraintLayout)itemView.findViewById(R.id.question_rcv_item_csl) ;
            tvAuthorTime = (TextView)itemView.findViewById(R.id.question_rcv_item_tv_author_time);
            tvTitle = (TextView)itemView.findViewById(R.id.question_rcv_item_tv_title);
            tvContent = (TextView)itemView.findViewById(R.id.question_rcv_item_tv_content);
            tvTag = (TextView)itemView.findViewById(R.id.question_rcv_item_tv_tag);
            tvAnswerCount = (TextView)itemView.findViewById(R.id.question_rcv_item_tv_answer_count);
        }
    }
}
