package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NewFeedFrag extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_frag2);

        //버튼 클릭시 액티비티 전환
        ImageButton post_btn = (ImageButton) findViewById(R.id.btn_post);
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotogridView.class);
                startActivity(intent);
            }
        });
    }
}
