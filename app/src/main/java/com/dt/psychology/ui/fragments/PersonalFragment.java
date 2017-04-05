package com.dt.psychology.ui.fragments;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.ui.activities.EditDataActivity;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment {

    @BindView(R.id.fragment_personal_cciv_head)
    CircleImageView cciv;
    @BindView(R.id.fragment_personal_tv_edit_data)
    TextView tvEditData;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        Glide.with(this).load(R.drawable.head_placeholder).into(cciv);
        tvEditData.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    int getContentViewId() {
        return R.layout.fragment_personal;
    }

    @Override
    void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.fragment_personal_tv_edit_data)
    public void editDataClick(){
        startActivity(EditDataActivity.class);
    }

}
