// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import com.synnapps.carouselview.CarouselView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131558555;

  private View view2131558566;

  private View view2131558564;

  private View view2131558562;

  private View view2131558560;

  private View view2131558557;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.carouselView = Utils.findRequiredViewAsType(source, R.id.fragment_home_cv, "field 'carouselView'", CarouselView.class);
    target.ivPush = Utils.findRequiredViewAsType(source, R.id.fragment_home_iv_push, "field 'ivPush'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_growth, "method 'categoryClick'");
    view2131558555 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_career, "method 'categoryClick'");
    view2131558566 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_family, "method 'categoryClick'");
    view2131558564 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_love_marriage, "method 'categoryClick'");
    view2131558562 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_sex, "method 'categoryClick'");
    view2131558560 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_social, "method 'signUpClick'");
    view2131558557 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.signUpClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.carouselView = null;
    target.ivPush = null;

    view2131558555.setOnClickListener(null);
    view2131558555 = null;
    view2131558566.setOnClickListener(null);
    view2131558566 = null;
    view2131558564.setOnClickListener(null);
    view2131558564 = null;
    view2131558562.setOnClickListener(null);
    view2131558562 = null;
    view2131558560.setOnClickListener(null);
    view2131558560 = null;
    view2131558557.setOnClickListener(null);
    view2131558557 = null;
  }
}
