// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiscussionFragment_ViewBinding implements Unbinder {
  private DiscussionFragment target;

  private View view2131624147;

  private View view2131624153;

  @UiThread
  public DiscussionFragment_ViewBinding(final DiscussionFragment target, View source) {
    this.target = target;

    View view;
    target.spnSort = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_spn_sort, "field 'spnSort'", Spinner.class);
    target.spnCategory = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_spn_category, "field 'spnCategory'", Spinner.class);
    target.rcvQuestion = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_rcv_question, "field 'rcvQuestion'", RecyclerView.class);
    target.srfly = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_srfly, "field 'srfly'", SwipeRefreshLayout.class);
    target.edtSearch = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_edt_search, "field 'edtSearch'", EditText.class);
    view = Utils.findRequiredView(source, R.id.fragment_discussion_iv_search, "method 'searchClick'");
    view2131624147 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.searchClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_discussion_ask_question, "method 'askQuestionClick'");
    view2131624153 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.askQuestionClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DiscussionFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spnSort = null;
    target.spnCategory = null;
    target.rcvQuestion = null;
    target.srfly = null;
    target.edtSearch = null;

    view2131624147.setOnClickListener(null);
    view2131624147 = null;
    view2131624153.setOnClickListener(null);
    view2131624153 = null;
  }
}
