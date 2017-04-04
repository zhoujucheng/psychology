// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalFragment_ViewBinding implements Unbinder {
  private PersonalFragment target;

  @UiThread
  public PersonalFragment_ViewBinding(PersonalFragment target, View source) {
    this.target = target;

    target.cciv = Utils.findRequiredViewAsType(source, R.id.fragment_personal_cciv_head, "field 'cciv'", CircleImageView.class);
    target.tvEditData = Utils.findRequiredViewAsType(source, R.id.fragment_personal_edit_data, "field 'tvEditData'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonalFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cciv = null;
    target.tvEditData = null;
  }
}
