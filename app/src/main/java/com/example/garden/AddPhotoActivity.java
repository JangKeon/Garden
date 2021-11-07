package com.example.garden;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;


public final class AddPhotoActivity extends AppCompatActivity {
    private int PICK_IMAGE_FROM_ALBUM = 0;
    @Nullable
    private FirebaseStorage storage = null;
    @Nullable
    private Uri photoUri = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        Button addphoto_btn = findViewById(R.id.addphoto_btn_upload);
        ImageView add_image = findViewById(R.id.addphoto_image);

        //storage 초기화
        storage = FirebaseStorage.getInstance();

        //앨범 오픈
        Intent photoPickerIntent = new Intent("android.intent.action.PICK");
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, PICK_IMAGE_FROM_ALBUM);

        //버튼 이벤트
        addphoto_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contentUpload();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_FROM_ALBUM){
            if(requestCode == Activity.RESULT_OK){
                //사진 선택시 이미지 경로가 넘어옴
                photoUri = data.getData();
                //add_image.setImageReSource(photoUri);
            }else{
                //취소 버튼 누른 시 작동
                finish();
            }
        }
    }
    public final void contentUpload(){
        //중복 생성되지 않는 파일명
        String timestamp = (new SimpleDateFormat("yyyyMMdd HHmmss")).format(new Date());
        String imageFileName = "IMAGE_" + timestamp + "_.png";

        StorageReference storageRef = storage.getReference().child("images").child(imageFileName);

        //파일 업로드
        storageRef.putFile(photoUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "upload success", Toast.LENGTH_LONG).show();
            }
        });

    }


}


