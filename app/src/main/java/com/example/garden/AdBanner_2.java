package com.example.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AdBanner_2 extends Fragment {

    @java.lang.Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ad_banner2,container,false);

        return rootView;
    }
}
