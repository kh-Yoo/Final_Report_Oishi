package com.example.oishi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FoodPagerAdapter extends FragmentStatePagerAdapter {
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private final List<Fragment> mFragmentList = new ArrayList<>();

    void addFragment(String title, Fragment fragment) {
        mFragmentTitleList.add(title);
        mFragmentList.add(fragment);
    }

    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    FoodPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
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