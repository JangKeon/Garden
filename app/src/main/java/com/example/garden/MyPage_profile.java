package com.example.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyPage_profile extends Fragment {
/*    private View view;

    public void onCreate(Bundle savedInstanceState)
    {super.onCreate(savedInstanceState);}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.mypage_profile,container, false);

        return view;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.mypage_profile,container,false);

        return rootView;
    }
}
