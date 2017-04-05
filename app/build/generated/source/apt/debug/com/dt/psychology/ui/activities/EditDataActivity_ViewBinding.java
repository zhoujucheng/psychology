// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditDataActivity_ViewBinding implements Unbinder {
  private EditDataActivity target;

  private View view2131624070;

  @UiThread
  public EditDataActivity_ViewBinding(EditDataActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditDataActivity_ViewBinding(final EditDataActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_edit_data_iv_back, "method 'backClick'");
    view2131624070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.backClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131624070.setOnClickListener(null);
    view2131624070 = null;
  }
}
