package com.dt.psychology.ui.activities;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;

import butterknife.OnClick;

public class EditDataActivity extends BaseSwipeBackActivity {

    @Override
    protected void init() {

    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_edit_data;
    }

    @OnClick(R.id.activity_edit_data_iv_back)
    public void backClick(){
        onBackPressed();
    }
}
