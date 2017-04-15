// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import com.synnapps.carouselview.CarouselView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131624157;

  private View view2131624159;

  private View view2131624168;

  private View view2131624166;

  private View view2131624164;

  private View view2131624162;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.carouselView = Utils.findRequiredViewAsType(source, R.id.fragment_home_cv, "field 'carouselView'", CarouselView.class);
    target.tvBrief = Utils.findRequiredViewAsType(source, R.id.fragment_home_tv_push_brief, "field 'tvBrief'", TextView.class);
    target.tvPageView = Utils.findRequiredViewAsType(source, R.id.fragment_home_tv_page_view, "field 'tvPageView'", TextView.class);
    target.ivPush = Utils.findRequiredViewAsType(source, R.id.fragment_home_iv_push, "field 'ivPush'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_growth, "method 'categoryClick'");
    view2131624157 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_social, "method 'categoryClick'");
    view2131624159 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_career, "method 'categoryClick'");
    view2131624168 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_family, "method 'categoryClick'");
    view2131624166 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_love_marriage, "method 'categoryClick'");
    view2131624164 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_csl_sex, "method 'categoryClick'");
    view2131624162 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.categoryClick(p0);
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
    target.tvBrief = null;
    target.tvPageView = null;
    target.ivPush = null;

    view2131624157.setOnClickListener(null);
    view2131624157 = null;
    view2131624159.setOnClickListener(null);
    view2131624159 = null;
    view2131624168.setOnClickListener(null);
    view2131624168 = null;
    view2131624166.setOnClickListener(null);
    view2131624166 = null;
    view2131624164.setOnClickListener(null);
    view2131624164 = null;
    view2131624162.setOnClickListener(null);
    view2131624162 = null;
  }
}
