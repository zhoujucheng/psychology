package com.dt.psychology.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.domain.Question;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by dnnt9 on 2017/4/3.
 */

public class QuestionRcvAdapter extends RecyclerView.Adapter<QuestionRcvAdapter.QuestionItemViewHolder> {

    private List<Question> questions;

    public QuestionRcvAdapter(List<Question> questions){
        if (questions == null)  questions = new ArrayList<>();
        this.questions = questions;
    }

    @Override
    public QuestionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_rcv_item,parent,false);
        return new QuestionItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionItemViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.tvAuthorTime.setText("匿名用户     01-31");
        holder.tvContent.setText("以前个给同事留下了不好的印象，形成不好的互动模式，容易被人误会，容易被人忽悠利用，工作上常常不得已加班，下班后休息严重不足。长期如此导致自控力，判断力，行动力下降。陷入恶性循环，我怎样改善这种局面？");
        holder.tvTitle.setText("如何改善人际互动模式");
        holder.tvTag.setText("工作与生活平衡 职场人际 职场压力");
        holder.tvAnswerCount.setText("1");
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class QuestionItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvAuthorTime;
        TextView tvTitle;
        TextView tvContent;
        TextView tvTag;
        TextView tvAnswerCount;
        public QuestionItemViewHolder(View itemView) {
            super(itemView);
            tvAuthorTime = (TextView)itemView.findViewById(R.id.question_rcv_item_author_time);
            tvTitle = (TextView)itemView.findViewById(R.id.question_rcv_item_title);
            tvContent = (TextView)itemView.findViewById(R.id.question_rcy_item_content);
            tvTag = (TextView)itemView.findViewById(R.id.question_rcv_item_tag);
            tvAnswerCount = (TextView)itemView.findViewById(R.id.question_rcv_item_answer_count);

        }
    }
}
