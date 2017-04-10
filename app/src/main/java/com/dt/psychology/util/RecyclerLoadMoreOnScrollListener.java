package com.dt.psychology.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;

/**
 * Created by dnnt9 on 2017/4/6.
 */

public abstract class RecyclerLoadMoreOnScrollListener extends RecyclerView.OnScrollListener {

    private boolean loading = true;
    private int previousTotal = 0;
    private int currentPage = 1;

    @Override
    public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        LinearLayoutManager layoutManager =(LinearLayoutManager) recyclerView.getLayoutManager();
        int visibleItemCount = layoutManager.getChildCount();
        int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
        int totalItemCount = layoutManager.getItemCount();
//        Log.e("LoadMoreOnScroll",String.valueOf(dy));
        if(loading && totalItemCount >= previousTotal){
            loading = false;
            previousTotal = totalItemCount;
        }
        if (!loading && totalItemCount - firstVisibleItem <= visibleItemCount && dy>=0){
            onLoadMore(currentPage);
            loading = true;
        }
    }

    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }

    public abstract void onLoadMore(int currentPage);

}
