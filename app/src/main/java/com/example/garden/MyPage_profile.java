package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

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


        TextView txtview = (TextView) rootView.findViewById(R.id.Logout_Text);
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(LoginActivity.class);
            }
        });

        return rootView;
    }



    private void startActivity(Class c){
        Intent intent = new Intent(getActivity(),c);
        startActivity(intent);
    }



}
