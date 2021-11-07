package com.example.garden;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private StoreFragment storeFragment;
    private FeedFragment feedFragment;
    private GPSFragment gpsFragment;
    private MyPageFragment myPageFragment;

    private DrawerLayout mDrawerLayout;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_store:
                        setFrag(1);
                        break;
                    case R.id.action_feed:
                        setFrag(2);
                        break;
                    case R.id.action_gps:
                        setFrag(3);
                        break;
                    case R.id.action_myPage:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        homeFragment = new HomeFragment();
        storeFragment = new StoreFragment();
        feedFragment = new FeedFragment();
        gpsFragment = new GPSFragment();
        myPageFragment = new MyPageFragment();
        setFrag(0);

        // Drawer 구현
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.drawer_menu); //뒤로가기 버튼 이미지 지정
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.history){
                    Toast.makeText(context, title + ": 계정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.logout){
                    Toast.makeText(context, title + " Success!", Toast.LENGTH_SHORT).show();
                    signOut();
                    startMyActivity(LoginActivity.class);
                }
                return true;
            }
        });
        // Drawer 구현


        // 로그인 된 상태가 아니라면
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startMyActivity(LoginActivity.class);
        } else {
            //refreshToken();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void refreshToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("Token", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // store to db
                        FirebaseAuth mAuth=FirebaseAuth.getInstance();
                        String email=mAuth.getCurrentUser().getEmail();
                        String key = email.split("@")[0];

                        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference tokenRef=rootRef.child("Tokens").child(key);
                        tokenRef.child("token").setValue(token);
                        tokenRef.child("key").setValue(key);
                    }
                });
    }

    private void startMyActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, homeFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, storeFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, feedFragment);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, gpsFragment);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, myPageFragment);
                ft.commit();
                break;
        }

    }
}

