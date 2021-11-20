package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import com.google.android.material.navigation.NavigationView;



import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {
    private View view;
    private ImageButton btnLivingRoom;
    private ImageButton post1;
    private DrawerLayout mDrawerLayout;
    private Context context = getActivity();

    public void onCreate(@Nullable Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_frag,container, false);
        return view;
    }



    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void startMyActivity(Class c) {
        Intent intent = new Intent(getActivity(), c);
        startActivity(intent);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setHasOptionsMenu(true);

        btnLivingRoom = view.findViewById(R.id.btnLivingRoom);
        post1 = view.findViewById(R.id.post1);

        btnLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LivingRoomActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onActivityCreated(@Nullable Bundle savedInstancestate) {
        super.onActivityCreated(savedInstancestate);
    }
}
