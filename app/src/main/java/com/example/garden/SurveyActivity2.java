package com.example.garden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class SurveyActivity2 extends Activity {
    ImageView[] imageViews = new ImageView[18];
    ImageButton[] imageButtons = new ImageButton[18];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey2);


        int[] imgId = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7,
                R.id.iv8, R.id.iv9, R.id.iv10, R.id.iv11, R.id.iv12};
        for(int i=0; i<12;i++){
            imageViews[i] = (ImageView) findViewById(imgId[i]);
            imageViews[i].setVisibility(View.INVISIBLE);
        }

        int[] btnId = {R.id.ib1, R.id.ib2, R.id.ib3, R.id.ib4, R.id.ib5, R.id.ib6, R.id.ib7,
                R.id.ib8, R.id.ib9, R.id.ib10, R.id.ib11, R.id.ib12};
        for(int i=0; i<12;i++){
            imageButtons[i] = (ImageButton) findViewById(btnId[i]);
            imageButtons[i].setOnClickListener(btnListener);
        }


        Button btnSurvey2 = findViewById(R.id.btnSurvey2);
        btnSurvey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //로그인 상태에서 뒤로가기 했을 때 로그인 창 안나오게
        startActivity(intent);
    }
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(int i=0; i<18;i++){
                if(v.getId() == imageButtons[i].getId()){
                    imageViews[i].setVisibility(View.VISIBLE);
                }
            }
        }
    };
}