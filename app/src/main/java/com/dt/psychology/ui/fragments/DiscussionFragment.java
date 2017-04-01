package com.dt.psychology.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.FragmentComponent;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscussionFragment extends BaseFragment {


    public DiscussionFragment() {
        // Required empty public constructor
    }


    @Override
    void init() {

    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_discussion;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
