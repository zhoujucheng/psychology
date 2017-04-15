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
import com.dt.psychology.presenter.fragments.PersonalFPresenter;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.activities.EditDataActivity;
import com.dt.psychology.ui.activities.MyCollectionsActivity;
import com.dt.psychology.ui.views.PersonalFView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment implements PersonalFView{

    @BindView(R.id.fragment_personal_cciv_head)
    CircleImageView cciv;
    @BindView(R.id.fragment_personal_tv_edit_data)
    TextView tvEditData;
    @Inject
    PersonalFPresenter personalFPresenter;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    void init() {
        personalFPresenter.attachView(this);
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

    @OnClick(R.id.fragment_personal_lly_my_collections)
    public void collectionsClick(){
        if (MyApplication.isNetworkUsable()){
            if (getMyApplication().getUser()!=null){
                startActivity(MyCollectionsActivity.class);
            }else {
                showToast(R.string.tip_please_login);
            }
        }else {
            showToast(R.string.network_unavailable);
        }

    }

}
