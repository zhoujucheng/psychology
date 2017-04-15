// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
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

  private View view2131624117;

  private View view2131624122;

  private View view2131624124;

  @UiThread
  public SignUpActivity_ViewBinding(SignUpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignUpActivity_ViewBinding(final SignUpActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_sign_up_btn_verification_code, "field 'btnVerificationCode' and method 'getVerificationCodeClick'");
    target.btnVerificationCode = Utils.castView(view, R.id.activity_sign_up_btn_verification_code, "field 'btnVerificationCode'", Button.class);
    view2131624117 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.getVerificationCodeClick(p0);
      }
    });
    target.tiedtPhoneEmail = Utils.findRequiredViewAsType(source, R.id.activity_sign_up_tiedt_phone_email, "field 'tiedtPhoneEmail'", TextInputEditText.class);
    target.tiedtVerificationCode = Utils.findRequiredViewAsType(source, R.id.activity_sign_up_tiedt_verification_code, "field 'tiedtVerificationCode'", TextInputEditText.class);
    target.tiedtNickname = Utils.findRequiredViewAsType(source, R.id.activity_sign_up_tiedt_nickname, "field 'tiedtNickname'", TextInputEditText.class);
    target.tiedtPassword = Utils.findRequiredViewAsType(source, R.id.activity_sign_up_tiedt_password, "field 'tiedtPassword'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.activity_sign_up_btn_sign_up, "method 'signUpClick'");
    view2131624122 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.signUpClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_sign_up_back, "method 'backClick'");
    view2131624124 = view;
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

    target.btnVerificationCode = null;
    target.tiedtPhoneEmail = null;
    target.tiedtVerificationCode = null;
    target.tiedtNickname = null;
    target.tiedtPassword = null;

    view2131624117.setOnClickListener(null);
    view2131624117 = null;
    view2131624122.setOnClickListener(null);
    view2131624122 = null;
    view2131624124.setOnClickListener(null);
    view2131624124 = null;
  }
}
