package com.example.garden;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdAdapter extends FragmentStateAdapter {
    public int mCount;
   //
    public  AdAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
        }

    @Nullable
    @java.lang.Override
    public Fragment createFragment(int position){
        int index = getRealPostion(position);

        if(index==0) return new AdBanner_1();
        else if(index==1) return new AdBanner_2();
        else if(index==2) return new AdBanner_3();
        else return new AdBanner_4();
    }

    @java.lang.Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPostion(int position){
        return  position % mCount;
    }

}
