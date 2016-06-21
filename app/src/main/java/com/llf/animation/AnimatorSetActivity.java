package com.llf.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by llf on 2016/6/21.
 * ObjectAnimator集合
 * 提供了两个方法playSequentially(按顺序播放)和playTogether(一起播放)
 * 所有参数以Set中设置为准，各个动画中的设置会失效.setStartDelay除外
 */
public class AnimatorSetActivity extends Activity{
    private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatorset);

        tv1 = (TextView)findViewById(R.id.tv_1);
        tv2 = (TextView)findViewById(R.id.tv_2);
    }

    public void start(View v){
        doPlaySequentiallyAnimator();
    }

    private void doPlaySequentiallyAnimator(){
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(tv1, "BackgroundColor",  0xffff00ff, 0xffffff00, 0xffff00ff);
        tv1BgAnimator.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(tv1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(tv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();

        //自己设置执行顺序
//        AnimatorSet.Builder builder = animatorSet.play(tv1TranslateY);
//        builder.with(tv2TranslateY);
//        builder.after(tv1BgAnimator);
    }
}
