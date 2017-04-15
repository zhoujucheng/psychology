// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AnswerDetailActivity_ViewBinding implements Unbinder {
  private AnswerDetailActivity target;

  @UiThread
  public AnswerDetailActivity_ViewBinding(AnswerDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AnswerDetailActivity_ViewBinding(AnswerDetailActivity target, View source) {
    this.target = target;

    target.tvQuestion = Utils.findRequiredViewAsType(source, R.id.activity_answer_detail_tv_question, "field 'tvQuestion'", TextView.class);
    target.tvAnswerAuthor = Utils.findRequiredViewAsType(source, R.id.activity_answer_detail_tv_answer_author, "field 'tvAnswerAuthor'", TextView.class);
    target.tvAnswerContent = Utils.findRequiredViewAsType(source, R.id.activity_answer_detail_tv_answer_content, "field 'tvAnswerContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AnswerDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvQuestion = null;
    target.tvAnswerAuthor = null;
    target.tvAnswerContent = null;
  }
}
