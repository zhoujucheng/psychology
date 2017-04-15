package com.dt.psychology.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.dt.psychology.dagger2.components.FragmentComponent;
import com.dt.psychology.dagger2.modules.FragmentModule;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.activities.BaseActivity;
import com.dt.psychology.ui.views.BaseView;
import com.dt.psychology.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment implements BaseView{

    private FragmentComponent mFragmentComponent;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this,view);
        mFragmentComponent = ((BaseActivity)getActivity()).getActivityComponent().plus(new FragmentModule());
        inject(mFragmentComponent);
        init();
        return view;
    }

    public FragmentComponent getFragmentComponent(){
        return mFragmentComponent;
    }

    @Override
    public void showToast(String text) {
        if(getActivity() != null && !getActivity().isFinishing()){
            ToastUtil.showToast(getContext(),text);
        }
    }

    @Override
    public void startActivity(Class<?> cls){
        startActivity(new Intent(getContext(),cls));
    }

    @Override
    public void showToast(int id) {
        if (!getActivity().isFinishing())
            ToastUtil.showToast(getContext(),id);
    }

    @Override
    public MyApplication getMyApplication() {
        return (MyApplication) getContext().getApplicationContext();
    }

    @Override
    public void activityFinish() {
        getActivity().finish();
    }

    @Override
    public AlertDialog showDialogWithBar(String title) {
        Context context = getContext();
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setView(new ProgressBar(context))
                .setCancelable(false)
                .create();
        alertDialog.show();
        return alertDialog;
    }

    @Override
    public void showDialog(String title, String content) {
        new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(content)
                .create()
                .show();
    }

    abstract void init();

    abstract int getContentViewId();

    abstract void inject(FragmentComponent fragmentComponent);

}
