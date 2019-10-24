package com.gauravk.bubblebarsample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.gauravk.bubblebarsample.R;
import com.gauravk.bubblebarsample.adapters.ScreenSlidePagerAdapter;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import java.util.ArrayList;

public class EqualBottomBarFragment extends Fragment {

    ViewPager viewPager;
    BubbleNavigationLinearView bnlView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_equal_bottom_bar, container, false);
        viewPager = inflatedView.findViewById(R.id.view_pager);
        bnlView = inflatedView.findViewById(R.id.equal_navigation_bar);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<ScreenSlidePageFragment> fragList = new ArrayList<>();
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.shop), R.color.blue_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.photos), R.color.purple_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.call), R.color.green_inactive));
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(fragList, getChildFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        // disable swipe
        viewPager.setOnTouchListener((v, event) -> true);

        bnlView.setNavigationChangeListener((view, position) -> viewPager.setCurrentItem(position, true));

        // Change the initial active element
        int newInitialPosition = 2;
        bnlView.setCurrentActiveItem(newInitialPosition);
        viewPager.setCurrentItem(newInitialPosition, false);
    }
}
