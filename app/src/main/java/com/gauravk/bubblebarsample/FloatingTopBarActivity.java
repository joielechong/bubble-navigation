package com.gauravk.bubblebarsample;

import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.gauravk.bubblebarsample.adapters.ScreenSlidePagerAdapter;
import com.gauravk.bubblebarsample.fragment.ScreenSlidePageFragment;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import java.util.ArrayList;

public class FloatingTopBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_floating_top_bar);
        BubbleNavigationConstraintView bncw = findViewById(R.id.floating_top_bar_navigation);
        bncw.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));
        bncw.setBadgeValue(0, "3");
        bncw.setBadgeValue(1, "9+"); //invisible badge

        ArrayList<ScreenSlidePageFragment> fragList = new ArrayList<>();
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.home), R.color.red_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.search), R.color.blue_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.likes), R.color.blue_grey_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.notification), R.color.green_inactive));
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(fragList, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        //disable swipe
        viewPager.setOnTouchListener((v, event) -> true);

        bncw.setNavigationChangeListener((view, position) -> viewPager.setCurrentItem(position, true));
    }
}
