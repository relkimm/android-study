package com.example.tutorial01.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tutorial01.R;
import com.example.tutorial01.view.TabFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

public class TabActivity extends AppCompatActivity {
    private List<String> tabNames = Arrays.asList("Movie", "TV", "Youtube");
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        setTabLayout();
        setViewPager();
    }

    private void setTabLayout() {
        tabLayout = findViewById(R.id.tab);
        tabNames.stream().forEach(tabName -> {
            tabLayout.addTab(tabLayout.newTab().setText(tabName));
        });
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.tab_view_pager);
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager(), 0);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
