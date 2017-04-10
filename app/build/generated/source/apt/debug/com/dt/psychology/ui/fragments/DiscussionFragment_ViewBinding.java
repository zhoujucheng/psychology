// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiscussionFragment_ViewBinding implements Unbinder {
  private DiscussionFragment target;

  @UiThread
  public DiscussionFragment_ViewBinding(DiscussionFragment target, View source) {
    this.target = target;

    target.spnSort = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_spn_sort, "field 'spnSort'", Spinner.class);
    target.spnCategory = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_spn_category, "field 'spnCategory'", Spinner.class);
    target.rcvQuestion = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_rcv_question, "field 'rcvQuestion'", RecyclerView.class);
    target.srfly = Utils.findRequiredViewAsType(source, R.id.fragment_discussion_srfly, "field 'srfly'", SwipeRefreshLayout.class);
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
  }
}
