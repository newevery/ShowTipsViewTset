package com.yzyx.tset;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import net.frederico.showtipsview.ShowTipsBuilder;
import net.frederico.showtipsview.ShowTipsView;
import net.frederico.showtipsview.ShowTipsViewInterface;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        ShowTipsView showtips =ShowTipUtil.shows(this,btn1,"btn1","btn1 desssssssssssss",1);

//                new ShowTipsBuilder(this)
//                .setTarget(btn1)//设置需要提示的控件
//                .setTitle("btn1")//设置显示的提示标题
//                .setDescription("btn1 desssssssssss")//设置显示的具体提示信息
//                .setDelay(1000)//设置进入界面后延迟时间显示提示
//                .setBackgroundColor(Color.BLACK)//设置提示背景颜色
//                .setBackgroundAlpha(0X77)//设置背景透明度
//                .setButtonText("下一步")//设置GOIT即按钮的显示文本
//                .setCloseButtonTextColor(Color.RED)
//                .displayOneTime(8)//设置当前控件的shopTipsId，此id唯一不能重复，重复的话值显示第一次
//                .build();
//        showtips.show(this);//设置显示的界面

        showtips.setCallback(new ShowTipsViewInterface() {//回调事件用于在一个页面顺序提示
            @Override
            public void gotItClicked() {
                ShowTipsView showtips2 = new ShowTipsBuilder(MainActivity.this)
                        .setTarget(btn2,btn2.getWidth()/2,btn2.getHeight()/2,40)//使用这个方法的时候，默认是以元素的左上角为圆心的
//                        .setTarget(btn2)//设置需要提示的控件，默认以控件的中心为圆心，半径为view.getHeight()/2
                        .setTitle("btn2")//设置显示的提示标题
                        .setDescription("btn2 desssssssssssssssssssssss")//设置显示的具体提示信息
                        .setDelay(1000)//设置进入界面后延迟时间显示提示
                        .setBackgroundColor(Color.GREEN)//设置提示背景颜色
                        .setBackgroundAlpha(0X77)//设置背景透明度
                        .setButtonText("下一步")//设置GOIT即按钮的显示文本
                        .displayOneTime(9)//设置当前控件的shopTipsId，此id唯一不能重复，重复的话值显示第一次,,,如果不设置这个属性每次启动都会有提示
                        .build();
                showtips2.show(MainActivity.this);//设置显示的界面
            }
        });

    }
}
