package com.example.garden;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {
    Context context;

    Integer[] posterID = {R.drawable.camera ,R.drawable.uploadimage ,R.drawable.mov_1, R.drawable.mov_2, R.drawable.mov_3, R.drawable.mov_4,
            R.drawable.mov_5, R.drawable.mov_6, R.drawable.mov_7, R.drawable.mov_8, R.drawable.mov_9, R.drawable.mov_10,
            R.drawable.mov_11, R.drawable.mov_12, R.drawable.mov_13, R.drawable.mov_14, R.drawable.mov_15, R.drawable.mov_16};


    public MyGridAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i){
        return null;
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(400,650));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        //imageView.setPadding(3,3,3,3);
        imageView.setImageResource(posterID[position]);

        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), PhotoUpload.class);
                view.getContext().startActivity(intent);
            }
        });
        return imageView;
    }
}
