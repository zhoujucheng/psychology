// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleDetailActivity_ViewBinding implements Unbinder {
  private ArticleDetailActivity target;

  private View view2131624077;

  @UiThread
  public ArticleDetailActivity_ViewBinding(ArticleDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ArticleDetailActivity_ViewBinding(final ArticleDetailActivity target, View source) {
    this.target = target;

    View view;
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.activity_article_detail_tv_content, "field 'tvContent'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.activity_article_detail_tv_title, "field 'tvTitle'", TextView.class);
    target.iv = Utils.findRequiredViewAsType(source, R.id.activity_article_detail_iv, "field 'iv'", ImageView.class);
    target.tvAuthorTime = Utils.findRequiredViewAsType(source, R.id.activity_article_detail_tv_author_time, "field 'tvAuthorTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.activity_article_detail_fabtn_collect, "method 'collectClick'");
    view2131624077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.collectClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ArticleDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvContent = null;
    target.tvTitle = null;
    target.iv = null;
    target.tvAuthorTime = null;

    view2131624077.setOnClickListener(null);
    view2131624077 = null;
  }
}
