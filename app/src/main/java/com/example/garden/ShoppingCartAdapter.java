package com.example.garden;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ShoppingCartAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public ShoppingCartAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                ShoppingCart_delivery frag1 = new ShoppingCart_delivery();
                return frag1;
            case 1:
                ShoppingCart_pickup frag2 = new ShoppingCart_pickup();
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
