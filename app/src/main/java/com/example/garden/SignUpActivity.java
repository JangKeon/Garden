package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    private String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();


        findViewById(R.id.btn_sendEmail).setOnClickListener(onClickListener);
        findViewById(R.id.text_login).setOnClickListener(onClickListener);



    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onBackPressed() {
        startLoginActivity();
    }

    View.OnClickListener onClickListener = (v) -> {

        switch (v.getId()) {
            case R.id.btn_sendEmail:
                Log.e("Sign Up", "회원가입 클릭");
                signUp();
                break;
            case R.id.text_login:
                startLoginActivity();
                break;

        }

    };

    private void signUp() {
        String email = ((EditText) findViewById(R.id.edit_email)).getText().toString();
        String nickName = ((EditText) findViewById(R.id.edit_nickname)).getText().toString();
        String password = ((EditText) findViewById(R.id.edit_password)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.edit_confirmPassword)).getText().toString();


        /* DB */
        String key = email.split("@")[0];   //key에 @는 저장이 안되므로 앞에 ID만 분리
        String domain = email.split("@")[1];

        if (email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0 && nickName.length() > 0) {

            if (password.equals(passwordCheck)) { // 비밀번호 체크
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, (task) -> {

                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();

                                startToast("회원가입에 성공하였습니다.");
                                startLoginActivity();
                                //UI
                            } else {
                                if (task.getException() != null) {
                                    startToast(task.getException().toString());
                                }
                            }

                        });
            } else {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        } else {
            startToast("입력하지 않은 항목이 있습니다");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}