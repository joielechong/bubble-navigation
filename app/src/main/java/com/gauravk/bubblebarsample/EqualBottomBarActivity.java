package com.gauravk.bubblebarsample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.gauravk.bubblebarsample.fragment.EqualBottomBarFragment;

public class EqualBottomBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equal_bottom_bar);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new EqualBottomBarFragment();
            addFragment(fragment, R.id.content_frame);
        }
    }

    private void addFragment(Fragment fragment, int id) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(id, fragment);
        ft.commit();
    }
}
