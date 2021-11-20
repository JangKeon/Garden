package com.example.garden;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public MyPageAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                MyPage_profile frag1 = new MyPage_profile();
                return frag1;
            case 1:
                MyPage_myshopping frag2 = new MyPage_myshopping();
                return frag2;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}