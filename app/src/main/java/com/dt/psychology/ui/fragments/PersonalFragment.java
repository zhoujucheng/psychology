package com.dt.psychology.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.FragmentComponent;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment {

    @BindView(R.id.fragment_personal_cciv_head)
    CircleImageView cciv;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        Glide.with(this).load(R.drawable.img3).into(cciv);
    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_personal;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

}
