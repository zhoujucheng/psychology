package com.dt.psychology.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.dt.psychology.ui.fragments.DiscussionFragment;
import com.dt.psychology.ui.fragments.HomeFragment;
import com.dt.psychology.ui.fragments.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public class MainAtyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;

    public MainAtyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new DiscussionFragment());
        mFragmentList.add(new PersonalFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
