package com.dt.psychology.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.ui.activities.BaseActivity;
import com.dt.psychology.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    private FragmentComponent mFragmentComponent;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this,view);
        inject(getFragmentComponent());
        init();
        return view;
    }

    public FragmentComponent getFragmentComponent(){
        if (mFragmentComponent == null){
            mFragmentComponent = ((BaseActivity)getActivity()).getActivityComponent().plus(new FragmentModule());
        }
        return mFragmentComponent;
    }

    public void showToast(String text) {
        ToastUtil.showToast(getContext(),text);
    }

    public void startActivity(Class<?> cls){
        startActivity(new Intent(getContext(),cls));
    }

    abstract void init();

    abstract int getContentViewId();

    abstract void inject(FragmentComponent fragmentComponent);

}
