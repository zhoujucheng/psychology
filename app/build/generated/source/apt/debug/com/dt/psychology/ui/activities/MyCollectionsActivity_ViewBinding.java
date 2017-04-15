// Generated code from Butter Knife. Do not modify!
package com.dt.psychology.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dt.psychology.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyCollectionsActivity_ViewBinding implements Unbinder {
  private MyCollectionsActivity target;

  @UiThread
  public MyCollectionsActivity_ViewBinding(MyCollectionsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyCollectionsActivity_ViewBinding(MyCollectionsActivity target, View source) {
    this.target = target;

    target.rcv = Utils.findRequiredViewAsType(source, R.id.activity_my_collections_rcv, "field 'rcv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyCollectionsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rcv = null;
  }
}
