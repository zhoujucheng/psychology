package com.dt.psychology.ui.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.ui.fragments.DiscussionFragment;
import com.dt.psychology.ui.fragments.HomeFragment;
import com.dt.psychology.ui.fragments.PersonalFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.activity_main_tv_home)
    TextView tvHome;
    @BindView(R.id.activity_main_iv_home)
    ImageView ivHome;
    @BindView(R.id.activity_main_tv_discussion)
    TextView tvDiscussion;
    @BindView(R.id.activity_main_iv_discussion)
    ImageView ivDiscussion;
    @BindView(R.id.activity_main_tv_persional)
    TextView tvPersonal;
    @BindView(R.id.activity_main_iv_personal)
    ImageView ivPersonal;

    private HomeFragment homeFragment;
    private DiscussionFragment discussionFragment;
    private PersonalFragment personalFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        homeFragment = new HomeFragment();
        discussionFragment = new DiscussionFragment();
        personalFragment = new PersonalFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.activity_main_fl_container,homeFragment)
                .add(R.id.activity_main_fl_container,discussionFragment)
                .add(R.id.activity_main_fl_container,personalFragment)
                .commit();
        homeClick();
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.activity_main_tv_home,R.id.activity_main_iv_home})
    public void homeClick(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(discussionFragment).hide(personalFragment).show(homeFragment).commit();
        resetBottomColor(tvHome,ivHome,R.drawable.ic_home_checked);
    }

    @OnClick({R.id.activity_main_tv_discussion,R.id.activity_main_iv_discussion})
    public void discussionClick(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(homeFragment).hide(personalFragment).show(discussionFragment).commit();
        resetBottomColor(tvDiscussion,ivDiscussion,R.drawable.ic_discuss_checked);
    }

    @OnClick({R.id.activity_main_tv_persional,R.id.activity_main_iv_personal})
    public void personalClick(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(discussionFragment).hide(homeFragment).show(personalFragment).commit();
        resetBottomColor(tvPersonal,ivPersonal,R.drawable.ic_personal_checked);
    }

    public void resetBottomColor(TextView tv,ImageView iv,int drawableId){
        tvHome.setTextColor(ContextCompat.getColor(this,R.color.colorTextUnchecked));
        ivHome.setImageResource(R.drawable.ic_home_unchecked);
        tvDiscussion.setTextColor(ContextCompat.getColor(this,R.color.colorTextUnchecked));
        ivDiscussion.setImageResource(R.drawable.ic_discuss_unchecked);
        tvPersonal.setTextColor(ContextCompat.getColor(this,R.color.colorTextUnchecked));
        ivPersonal.setImageResource(R.drawable.ic_personal_unchecked);
        tv.setTextColor(ContextCompat.getColor(this,R.color.colorTextChecked));
        iv.setImageResource(drawableId);
    }
}
