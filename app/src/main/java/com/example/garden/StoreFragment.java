package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import me.relex.circleindicator.CircleIndicator3;

public class StoreFragment extends Fragment {

    private View view;
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;
    private ImageButton btnCategory1;


    public StoreFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.store_frag, container, false);

        // 가로스와이프 광고 배너 view fragment
        mPager = (ViewPager2) view.findViewById(R.id.viewPager_adbanner);
        pagerAdapter = new AdAdapter(getActivity(), num_page);
        mPager.setAdapter(pagerAdapter);

        mIndicator = (CircleIndicator3) view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);

        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // 처음 시작하는 이미지 설정
        mPager.setCurrentItem(1000); // 시작지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position,positionOffset,positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setHasOptionsMenu(true);

        btnCategory1= view.findViewById(R.id.category3);

        btnCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Category1Activity.class);
                startActivity(intent);
            }
        });

    }

}
