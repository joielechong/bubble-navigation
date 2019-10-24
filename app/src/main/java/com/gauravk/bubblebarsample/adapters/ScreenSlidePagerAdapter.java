package com.gauravk.bubblebarsample.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.gauravk.bubblebarsample.fragment.ScreenSlidePageFragment;

import java.util.ArrayList;


/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ScreenSlidePageFragment> fragmentList;

    public ScreenSlidePagerAdapter(ArrayList<ScreenSlidePageFragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if(position >= 0 && position < fragmentList.size()) {
            return fragmentList.get(position);
        }

        return new ScreenSlidePageFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
