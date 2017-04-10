package com.dt.psychology.adapters;

import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dt.psychology.R;

/**
 * Created by dnnt9 on 2017/4/7.
 */

public abstract class FooterAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int ITEM_TYPE = 1;
    //正在加载
    public static final int FOOTER_LOAD_MORE = 2;
    //没有更多
    public static final int FOOTER_NO_MORE=3;
    //加载失败
    public static final int FOOTER_LOAD_FAIL=4;
    //加载成功后的状态
    public static final int FOOTER_HIDING = 5;
    //当前加载状态
    private int footerStatus = FOOTER_HIDING;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE){
            return getViewHolder(parent);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycerview_footer,parent,false);
            FooterHolder holder = new FooterHolder(view);
            if (viewType == FOOTER_LOAD_MORE) {
                holder.prb.setVisibility(View.VISIBLE);
                holder.tv.setText("正在加载...");
            }else if (viewType == FOOTER_NO_MORE){
                holder.prb.setVisibility(View.INVISIBLE);
                holder.tv.setText("没有更多");
            }else if (viewType == FOOTER_LOAD_FAIL){
                holder.prb.setVisibility(View.INVISIBLE);
                holder.tv.setText("加载失败");
            }else {
                holder.prb.setVisibility(View.INVISIBLE);
                holder.tv.setText("");
            }
            return holder;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < getItemCount() -1)  itemBindViewHolder((T) holder,position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getItemCount() - 1)
            return ITEM_TYPE;
        return footerStatus;
    }

    public abstract T getViewHolder(ViewGroup parent);

    public abstract void itemBindViewHolder(T holder,int position);

    public void setFooterStatus(int status){
        footerStatus = status;
        notifyDataSetChanged();
    }

    public int getFooterStatus(){
        return footerStatus;
    }

    private class FooterHolder extends RecyclerView.ViewHolder{
        private ProgressBar prb;
        private TextView tv;
        public FooterHolder(View itemView) {
            super(itemView);
            prb = (ProgressBar)itemView.findViewById(R.id.footer_pgb);
            tv = (TextView)itemView.findViewById(R.id.footer_tv);
        }
    }
}
