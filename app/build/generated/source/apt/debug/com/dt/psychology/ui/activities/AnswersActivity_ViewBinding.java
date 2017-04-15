// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AnswersActivity_ViewBinding implements Unbinder {
  private AnswersActivity target;

  private View view2131624067;

  @UiThread
  public AnswersActivity_ViewBinding(AnswersActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AnswersActivity_ViewBinding(final AnswersActivity target, View source) {
    this.target = target;

    View view;
    target.tvAuthorTime = Utils.findRequiredViewAsType(source, R.id.activity_answer_tv_question_author_time, "field 'tvAuthorTime'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.activity_answer_tv_question_title, "field 'tvTitle'", TextView.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.activity_answer_tv_question_content, "field 'tvContent'", TextView.class);
    target.tvTag = Utils.findRequiredViewAsType(source, R.id.activity_answer_tv_question_tag, "field 'tvTag'", TextView.class);
    target.tvAnswerCount = Utils.findRequiredViewAsType(source, R.id.activity_answer_tv_question_answer_count, "field 'tvAnswerCount'", TextView.class);
    target.rcv = Utils.findRequiredViewAsType(source, R.id.activity_answer_rcv, "field 'rcv'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.activity_answer_fabtn_write_answer, "method 'writeAnswerClick'");
    view2131624067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.writeAnswerClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AnswersActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAuthorTime = null;
    target.tvTitle = null;
    target.tvContent = null;
    target.tvTag = null;
    target.tvAnswerCount = null;
    target.rcv = null;

    view2131624067.setOnClickListener(null);
    view2131624067 = null;
  }
}
