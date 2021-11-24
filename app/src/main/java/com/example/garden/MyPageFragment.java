package com.example.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MyPageFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.mypage_frag,container, false);

        TabLayout tL;
        ViewPager vP;

        tL = (TabLayout) view.findViewById(R.id.my_tab);
        vP = (ViewPager) view.findViewById(R.id.my_view);

        tL.addTab(tL.newTab().setText("프로필"));
        tL.addTab(tL.newTab().setText("나의 쇼핑"));

        MyPageAdapter adapter = new MyPageAdapter(getChildFragmentManager(),
                tL.getTabCount());

        vP.setAdapter(adapter);

        tL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        return view;

    }
}
