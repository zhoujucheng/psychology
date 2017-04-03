package com.dt.psychology.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.psychology.R;
import com.dt.psychology.adapters.MainAtyFragmentPagerAdapter;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.ui.fragments.DiscussionFragment;
import com.dt.psychology.ui.fragments.HomeFragment;
import com.dt.psychology.ui.fragments.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.activity_main_tv_personal)
    TextView tvPersonal;
    @BindView(R.id.activity_main_iv_personal)
    ImageView ivPersonal;
    @BindView(R.id.activity_main_vp)
    ViewPager vp;

    @Override
    protected void init() {
        initViewPager();
        homeClick();

    }

    private void initViewPager(){
        MainAtyFragmentPagerAdapter vpAdapter = new MainAtyFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(vpAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        homeClick();
                        break;
                    case 1:
                        discussionClick();
                        break;
                    case 2:
                        personalClick();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
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
    public void homeClick() {
        if (vp.getCurrentItem() != 0) {
            vp.setCurrentItem(0);
        }
        resetBottomColor(tvHome, ivHome, R.drawable.ic_home_checked);
        Log.e("memory", String.valueOf(Runtime.getRuntime().totalMemory() / 1024.0D / 1024));
        showToast( String.valueOf(Runtime.getRuntime().totalMemory() / 1024.0D / 1024)+"M");
    }

    @OnClick({R.id.activity_main_tv_discussion,R.id.activity_main_iv_discussion})
    public void discussionClick(){
        if (vp.getCurrentItem() != 1){
            vp.setCurrentItem(1);
        }
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        showToast(String.valueOf(metrics.density)+" , "+String.valueOf(metrics.xdpi)+", "+String.valueOf(metrics.ydpi));
        resetBottomColor(tvDiscussion,ivDiscussion,R.drawable.ic_discuss_checked);
    }

    @OnClick({R.id.activity_main_tv_personal,R.id.activity_main_iv_personal})
    public void personalClick(){
        if (vp.getCurrentItem() != 2 ){
            vp.setCurrentItem(2);
        }
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
