package com.example.dell.circularanim;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.dell.mycirc.CircularAnimUtil;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    Button mChangeBtn, mActivityImageBtn, mActivityColorBtn, mActivityFinishBtn;
    ImageView mLogoBtnIv;
    LinearLayout mContentLayout;
    boolean isContentVisible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mChangeBtn = (Button) findViewById(R.id.change_btn);
        mActivityImageBtn = (Button) findViewById(R.id.activity_image_btn);
        mActivityColorBtn = (Button) findViewById(R.id.activity_color_btn);
        mActivityFinishBtn = (Button) findViewById(R.id.activity_finish_btn);
        mLogoBtnIv = (ImageView) findViewById(R.id.logoBtn_iv);
        mContentLayout = (LinearLayout) findViewById(R.id.content_layout);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChangeBtn.setEnabled(false);
                mProgressBar.setVisibility(View.VISIBLE);
                                CircularAnimUtil.hide(mChangeBtn);
            }
        });

        mProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressBar.setVisibility(View.GONE);
                mChangeBtn.setEnabled(true);

                CircularAnimUtil.show(mChangeBtn);
            }
        });

        mActivityImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CircularAnimUtil.startActivity(MainActivity.this, EmptyActivity.class, view, R.drawable.img_huoer_black);
            }
        });

        mActivityColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CircularAnimUtil.startActivity(MainActivity.this, EmptyActivity.class, view, R.color.colorPrimary);
            }
        });

        mActivityFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EmptyActivity.class);
                CircularAnimUtil.startActivityThenFinish(MainActivity.this, intent, view, R.color.colorPrimary);
            }
        });

        mLogoBtnIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.animate().rotationBy(90);
                // 以 @mLogoBtnIv 为中心，收缩或伸展 @mContentLayout
                if (isContentVisible)
                    CircularAnimUtil.hideOther(mLogoBtnIv, mContentLayout);
                else
                    CircularAnimUtil.showOther(mLogoBtnIv, mContentLayout);

                isContentVisible = !isContentVisible;
            }
        });
    }
}
