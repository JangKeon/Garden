package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Product2Activity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product2);

        ImageButton topShoppingCart = findViewById(R.id.topShoppingCart);
        topShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        TabLayout tL;
        ViewPager vP;

        tL = (TabLayout) findViewById(R.id.my_tab);
        vP = (ViewPager) findViewById(R.id.my_view);

        tL.addTab(tL.newTab().setText("상품 정보"));
        tL.addTab(tL.newTab().setText("후기 (20)"));
        tL.addTab(tL.newTab().setText("문의"));

        ProductAdapter adapter = new ProductAdapter(getSupportFragmentManager(),
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

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void onShoppingCartClick (View view){
        Toast.makeText(getApplicationContext(), "장바구니에 담겼습니다.", Toast.LENGTH_SHORT).show();
    }
}