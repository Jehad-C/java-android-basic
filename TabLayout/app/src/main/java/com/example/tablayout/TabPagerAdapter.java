package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayout.fragments.Fragment1;
import com.example.tablayout.fragments.Fragment2;
import com.example.tablayout.fragments.Fragment3;
import com.example.tablayout.fragments.Fragment4;
import com.example.tablayout.fragments.Fragment5;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return  new Fragment4();
            case 4:
                return new Fragment5();
            default:
                return new Fragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
