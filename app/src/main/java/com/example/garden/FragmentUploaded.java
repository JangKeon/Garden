package com.example.garden;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Objects;


public class FragmentUploaded extends Fragment implements View.OnClickListener {
    @Nullable
    private View view;
    private ImageButton postBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = Objects.requireNonNull(inflater).inflate(R.layout.fragment_uploaded,container, false);

        // Inflate the layout for this fragment
        //버튼 클릭시 액티비티 전환
        postBtn = (ImageButton) view.findViewById(R.id.btn_post);
        postBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), PhotogridView.class);
        startActivity(intent);
    }

}