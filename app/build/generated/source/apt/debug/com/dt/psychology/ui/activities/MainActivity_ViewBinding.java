// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131427431;

  private View view2131427434;

  private View view2131427430;

  private View view2131427433;

  private View view2131427432;

  private View view2131427435;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_main_tv_home, "field 'tvHome' and method 'homeClick'");
    target.tvHome = Utils.castView(view, R.id.activity_main_tv_home, "field 'tvHome'", TextView.class);
    view2131427431 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.homeClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_iv_home, "field 'ivHome' and method 'homeClick'");
    target.ivHome = Utils.castView(view, R.id.activity_main_iv_home, "field 'ivHome'", ImageView.class);
    view2131427434 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.homeClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_tv_discussion, "field 'tvDiscussion' and method 'discussionClick'");
    target.tvDiscussion = Utils.castView(view, R.id.activity_main_tv_discussion, "field 'tvDiscussion'", TextView.class);
    view2131427430 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.discussionClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_iv_discussion, "field 'ivDiscussion' and method 'discussionClick'");
    target.ivDiscussion = Utils.castView(view, R.id.activity_main_iv_discussion, "field 'ivDiscussion'", ImageView.class);
    view2131427433 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.discussionClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_tv_personal, "field 'tvPersonal' and method 'personalClick'");
    target.tvPersonal = Utils.castView(view, R.id.activity_main_tv_personal, "field 'tvPersonal'", TextView.class);
    view2131427432 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.personalClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_iv_personal, "field 'ivPersonal' and method 'personalClick'");
    target.ivPersonal = Utils.castView(view, R.id.activity_main_iv_personal, "field 'ivPersonal'", ImageView.class);
    view2131427435 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.personalClick();
      }
    });
    target.vp = Utils.findRequiredViewAsType(source, R.id.activity_main_vp, "field 'vp'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvHome = null;
    target.ivHome = null;
    target.tvDiscussion = null;
    target.ivDiscussion = null;
    target.tvPersonal = null;
    target.ivPersonal = null;
    target.vp = null;

    view2131427431.setOnClickListener(null);
    view2131427431 = null;
    view2131427434.setOnClickListener(null);
    view2131427434 = null;
    view2131427430.setOnClickListener(null);
    view2131427430 = null;
    view2131427433.setOnClickListener(null);
    view2131427433 = null;
    view2131427432.setOnClickListener(null);
    view2131427432 = null;
    view2131427435.setOnClickListener(null);
    view2131427435 = null;
  }
}