package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by XK on 2017/5/30.
 */

public class MainActivity extends Activity {
    RadioGroup rg;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //h获取界面上的rg、show两个组件
        rg= (RadioGroup) findViewById(R.id.rg);
        show=(TextView) findViewById(R.id.show);
        //为RadioGroup组件上的OnCheckedChange事件绑定事件监听器
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //根据用户勾选单选按钮来动态改变tip字符串的指
                String tip=i==R.id.male?"您的性别是男人":"您的性别是女人";
                //修改show组件中的文本
                show.setText(tip);
            }
        });
    }
}
