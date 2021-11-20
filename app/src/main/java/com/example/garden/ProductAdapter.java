package com.example.garden;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public ProductAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                Product1_info frag1 = new Product1_info();
                return frag1;
            case 1:
                Product1_review frag2 = new Product1_review();
                return frag2;
            case 2:
                Product1_inquiry frag3 = new Product1_inquiry();
                return frag3;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}