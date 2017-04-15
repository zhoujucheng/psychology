// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalFragment_ViewBinding implements Unbinder {
  private PersonalFragment target;

  private View view2131624185;

  private View view2131624181;

  @UiThread
  public PersonalFragment_ViewBinding(final PersonalFragment target, View source) {
    this.target = target;

    View view;
    target.cciv = Utils.findRequiredViewAsType(source, R.id.fragment_personal_cciv_head, "field 'cciv'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.fragment_personal_tv_edit_data, "field 'tvEditData' and method 'editDataClick'");
    target.tvEditData = Utils.castView(view, R.id.fragment_personal_tv_edit_data, "field 'tvEditData'", TextView.class);
    view2131624185 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.editDataClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_personal_lly_my_collections, "method 'collectionsClick'");
    view2131624181 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.collectionsClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonalFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cciv = null;
    target.tvEditData = null;

    view2131624185.setOnClickListener(null);
    view2131624185 = null;
    view2131624181.setOnClickListener(null);
    view2131624181 = null;
  }
}
