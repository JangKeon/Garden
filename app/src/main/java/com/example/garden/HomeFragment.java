package com.example.garden;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private View view;
    private ImageButton btnLivingRoom;

    private ImageButton btnSearch;
    private ImageButton btnShoppingCart;



    private ImageButton ibPost1;
    private Button btnPost1;

    private FloatingActionButton fab;
    private ImageView ivFeed;
    private Button btnFabAddFeed;
    //
    private Button btnTag1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_frag,container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setHasOptionsMenu(true);

        fab = view.findViewById(R.id.btnFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.layout_bottom_sheet);
                bottomSheetDialog.show();
            }
        });


        btnSearch = view.findViewById(R.id.btnSearch);
        btnSearch.setColorFilter(Color.parseColor("#000000"));
        btnShoppingCart = view.findViewById(R.id.btnShoppingCart);
        btnShoppingCart.setColorFilter(Color.parseColor("#000000"));

        btnLivingRoom = view.findViewById(R.id.btnLivingRoom);
        btnLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LivingRoomActivity.class);
                startActivity(intent);
            }
        });

        ibPost1 = view.findViewById(R.id.ibPost1);
        ibPost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomePostActivity.class);
                startActivity(intent);
            }
        });
        btnPost1 = view.findViewById(R.id.btnPost1);
        btnPost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomePostActivity.class);
                startActivity(intent);
            }
        });


        //
        btnTag1 = view.findViewById(R.id.btnTag1);
        btnTag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
