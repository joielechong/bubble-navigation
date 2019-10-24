package com.gauravk.bubblebarsample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTopNavigationBar = findViewById(R.id.open_top_navigation_bar);
        Button btnTopFloatNavigationBar = findViewById(R.id.open_top_float_navigation_bar);
        Button btnBottomEqualNavigation = findViewById(R.id.open_bottom_equal_navigation_bar);
        Button btnBottomNavigation = findViewById(R.id.open_bottom_navigation_bar);

        btnTopNavigationBar.setOnClickListener(v -> launchTopBarActivity());
        btnTopFloatNavigationBar.setOnClickListener(v -> launchFloatingBarActivity());
        btnBottomEqualNavigation.setOnClickListener(v -> launchEqualBarActivity());
        btnBottomNavigation.setOnClickListener(v -> launchBottomBarActivity());
    }

    private void launchTopBarActivity() {
        Intent intent = new Intent(this, TopBarActivity.class);
        startActivity(intent);
    }

    private void launchFloatingBarActivity() {
        Intent intent = new Intent(this, FloatingTopBarActivity.class);
        startActivity(intent);
    }

    private void launchBottomBarActivity() {
        Intent intent = new Intent(this, BottomBarActivity.class);
        startActivity(intent);
    }


    private void launchEqualBarActivity() {
        Intent intent = new Intent(this, EqualBottomBarActivity.class);
        startActivity(intent);
    }
}
