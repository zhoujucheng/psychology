// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131624088;

  private View view2131624090;

  private View view2131624087;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.tiedtPhoneEmail = Utils.findRequiredViewAsType(source, R.id.activity_login_tiedt_phone_email, "field 'tiedtPhoneEmail'", TextInputEditText.class);
    target.tiedtPassword = Utils.findRequiredViewAsType(source, R.id.activity_login_tiedt_password, "field 'tiedtPassword'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.activity_login_tv_look_around, "method 'lookAroundClick'");
    view2131624088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.lookAroundClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_login_tv_sign_up, "method 'signUpClick'");
    view2131624090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.signUpClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_login_btn_login, "method 'loginClick'");
    view2131624087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tiedtPhoneEmail = null;
    target.tiedtPassword = null;

    view2131624088.setOnClickListener(null);
    view2131624088 = null;
    view2131624090.setOnClickListener(null);
    view2131624090 = null;
    view2131624087.setOnClickListener(null);
    view2131624087 = null;
  }
}
