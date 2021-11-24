package com.example.garden;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ShoppingCartActivity extends FragmentActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        TabLayout tL;
        ViewPager vP;

        tL = (TabLayout) findViewById(R.id.my_tab);
        vP = (ViewPager) findViewById(R.id.my_view);

        tL.addTab(tL.newTab().setText("택배 배송"));
        tL.addTab(tL.newTab().setText("가게 픽업"));

        ShoppingCartAdapter adapter = new ShoppingCartAdapter(getSupportFragmentManager(),
                tL.getTabCount());

        vP.setAdapter(adapter);

        tL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @java.lang.Override
            public void onTabSelected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }

            @java.lang.Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @java.lang.Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @java.lang.Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
