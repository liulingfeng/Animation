package com.llf.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 补间动画和逐帧动画
 */
public class ViewAnimationActivity extends Activity {
    private Animation mAnimation;//补间动画
    private TextView tv;
    private ImageView iv;
    private AnimationDrawable mAnimationDrawable;//逐帧动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnimation = AnimationUtils.loadAnimation(this,R.anim.setanim);
        //代码中设置setanim
        /**
         *
         Animation alphaAnimation = new AlphaAnimation(0,1);
         Animation scaleAnimation = new ScaleAnimation(0,1.4f,0,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
         Animation rotateAnimation = new RotateAnimation(0,720,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
         AnimationSet setAnimation = new AnimationSet(true);设置为true指在AnimationSet中设置一个插值器，其他动画共用
         setAnimation.addAnimation(alphaAnimation);
         setAnimation.addAnimation(scaleAnimation);
         setAnimation.addAnimation(rotateAnimation);
         setAnimation.setFillAfter(true);
         setAnimation.setDuration(800);
         */
        tv = (TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);
        mAnimationDrawable = (AnimationDrawable)iv.getBackground();
    }

    public void start(View v){
        tv.startAnimation(mAnimation);
        mAnimationDrawable.start();
    }
}
