package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by XK on 2017/5/29.
 */

public class MainActivity extends Activity {
    private int currentColor=0;
    final int[] colors=new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };
    final int[] names=new int[]{
            R.id.tv01,
            R.id.tv02,
            R.id.tv03,
            R.id.tv04,
            R.id.tv05,
            R.id.tv06
    };
    TextView[] views=new TextView[names.length];
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123)
            {
                //表明消息来自本程序所发送
                for(int i=0;i<names.length;i++)
                {
                    views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        for(int i=0;i<names.length;i++)
        {
            views[i] = (TextView) findViewById(names[i]);
        }
        //定义一个线程周期性的改变cuurrentColor变量值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条空消息通知系统改变6个TextView组件的背景色
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
    }
}
