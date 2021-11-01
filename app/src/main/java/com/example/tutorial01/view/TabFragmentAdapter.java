package com.example.tutorial01.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tutorial01.fragment.Tab1Fragment;
import com.example.tutorial01.fragment.Tab2Fragment;
import com.example.tutorial01.fragment.Tab3Fragment;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    public TabFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new Tab1Fragment();
            case 2:
                return new Tab2Fragment();
            case 3:
                return new Tab3Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
