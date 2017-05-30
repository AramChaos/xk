package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
     //定义一个访问图片的数组
    int [] images=new int[]{
             R.drawable.java,
             R.drawable.ajax,
             R.drawable.html,
             R.drawable.javaee,
             R.drawable.swift,
     };
    int currentImg=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取LinearLayout布局容器
        LinearLayout main= (LinearLayout) findViewById(R.id.activity_main);
        //程序创建ImaageView组件
        final ImageView image=new ImageView(this);
        //将ImageView组件添加到LinearLayout布局容器中
        main.addView(image);
        //初始化时显示的第一张图片
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变ImageView里显示的图片
                image.setImageResource(images[++currentImg%images.length]);
            }
        });
    }
}
