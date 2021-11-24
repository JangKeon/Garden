package com.example.garden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class SimpleLoginActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_login);
        findViewById(R.id.email_login_text).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener= (v)-> {
        switch (v.getId()) {
            case R.id.email_login_text:
                startActivity(LoginActivity.class);
                break;

        }
    };

    private void startActivity(Class c){
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //로그인 상태에서 뒤로가기 했을 때 로그인 창 안나오게
        startActivity(intent);
    }
}
