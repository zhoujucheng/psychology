// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleActivity_ViewBinding implements Unbinder {
  private ArticleActivity target;

  @UiThread
  public ArticleActivity_ViewBinding(ArticleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ArticleActivity_ViewBinding(ArticleActivity target, View source) {
    this.target = target;

    target.rcv = Utils.findRequiredViewAsType(source, R.id.activity_article_rcv, "field 'rcv'", RecyclerView.class);
    target.srfly = Utils.findRequiredViewAsType(source, R.id.activity_article_srfly, "field 'srfly'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ArticleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rcv = null;
    target.srfly = null;
  }
}
