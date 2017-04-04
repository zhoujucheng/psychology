// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpActivity_ViewBinding implements Unbinder {
  private SignUpActivity target;

  private View view2131624088;

  private View view2131624091;

  @UiThread
  public SignUpActivity_ViewBinding(SignUpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignUpActivity_ViewBinding(final SignUpActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_sign_up_btn_validate_code, "field 'btnValidateCode' and method 'getValidateCodeClick'");
    target.btnValidateCode = Utils.castView(view, R.id.activity_sign_up_btn_validate_code, "field 'btnValidateCode'", Button.class);
    view2131624088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.getValidateCodeClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_sign_up_back, "method 'backClick'");
    view2131624091 = view;
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
    SignUpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnValidateCode = null;

    view2131624088.setOnClickListener(null);
    view2131624088 = null;
    view2131624091.setOnClickListener(null);
    view2131624091 = null;
  }
}
