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

  private View view2131427443;

  private View view2131427454;

  private View view2131427452;

  private View view2131427450;

  private View view2131427448;

  private View view2131427445;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.carouselView = Utils.findRequiredViewAsType(source, R.id.fragment_home_cv, "field 'carouselView'", CarouselView.class);
    target.ivPush = Utils.findRequiredViewAsType(source, R.id.fragment_home_iv_push, "field 'ivPush'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_growth, "method 'categoryClick'");
    view2131427443 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_career, "method 'categoryClick'");
    view2131427454 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_family, "method 'categoryClick'");
    view2131427452 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_love_marriage, "method 'categoryClick'");
    view2131427450 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_sex, "method 'categoryClick'");
    view2131427448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_social, "method 'categoryClick'");
    view2131427445 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick();
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

    view2131427443.setOnClickListener(null);
    view2131427443 = null;
    view2131427454.setOnClickListener(null);
    view2131427454 = null;
    view2131427452.setOnClickListener(null);
    view2131427452 = null;
    view2131427450.setOnClickListener(null);
    view2131427450 = null;
    view2131427448.setOnClickListener(null);
    view2131427448 = null;
    view2131427445.setOnClickListener(null);
    view2131427445 = null;
  }
}
