// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AskQuestionActivity_ViewBinding implements Unbinder {
  private AskQuestionActivity target;

  private View view2131624083;

  @UiThread
  public AskQuestionActivity_ViewBinding(AskQuestionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AskQuestionActivity_ViewBinding(final AskQuestionActivity target, View source) {
    this.target = target;

    View view;
    target.edtQuestion = Utils.findRequiredViewAsType(source, R.id.activity_ask_question_edt_question, "field 'edtQuestion'", EditText.class);
    target.edtDetail = Utils.findRequiredViewAsType(source, R.id.activity_ask_question_edt_detail, "field 'edtDetail'", EditText.class);
    target.spnTag = Utils.findRequiredViewAsType(source, R.id.activity_ask_question_spn_tag, "field 'spnTag'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.activity_ask_question_btn_commit, "method 'commitClick'");
    view2131624083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commitClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AskQuestionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtQuestion = null;
    target.edtDetail = null;
    target.spnTag = null;

    view2131624083.setOnClickListener(null);
    view2131624083 = null;
  }
}
