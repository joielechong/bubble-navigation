package com.gauravk.bubblebarsample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.gauravk.bubblebarsample.adapters.ScreenSlidePagerAdapter;
import com.gauravk.bubblebarsample.fragment.ScreenSlidePageFragment;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import java.util.ArrayList;

public class TopBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);

        ArrayList<ScreenSlidePageFragment> fragList = new ArrayList<>();
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.restaurant), R.color.orange_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.room), R.color.red_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.happy), R.color.green_inactive));
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(fragList, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        BubbleNavigationConstraintView bncw = findViewById(R.id.top_navigation_constraint);
        bncw.setNavigationChangeListener((view, position) -> viewPager.setCurrentItem(position, true));
    }
}
