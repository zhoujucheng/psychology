// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WriteCommentActivity_ViewBinding implements Unbinder {
  private WriteCommentActivity target;

  private View view2131624127;

  @UiThread
  public WriteCommentActivity_ViewBinding(WriteCommentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WriteCommentActivity_ViewBinding(final WriteCommentActivity target, View source) {
    this.target = target;

    View view;
    target.edtAnswer = Utils.findRequiredViewAsType(source, R.id.activity_write_comment_edt_answer, "field 'edtAnswer'", EditText.class);
    view = Utils.findRequiredView(source, R.id.activity_write_coment_btn_commit, "method 'commitClick'");
    view2131624127 = view;
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
    WriteCommentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtAnswer = null;

    view2131624127.setOnClickListener(null);
    view2131624127 = null;
  }
}
