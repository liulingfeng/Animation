package com.llf.animation;

import android.animation.Animator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by llf on 2016/6/21.
 * 属性动画,分为ValueAnimator和ObjectAnimator
 * ValueAnimator是针对值得，不是针对控件的
 */
public class PropertyActivity extends Activity{
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        tv = (TextView)findViewById(R.id.tv);
    }

    public void start(View v){
        startAnimator();
    }

    /**
     * 整个动画的实际实现过程
     * ofInt(0,400)-->插值器（返回数值进度）-->Evaluator(根据数值进度计算当前值)-->监听器返回
     *
     */
    private ValueAnimator startAnimator(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);//循环次数
        animator.setRepeatMode(ValueAnimator.REVERSE);//循环模式
        animator.setStartDelay(200);//延迟200毫秒开始
        animator.setInterpolator(new CustomInterpolator());//插值器,用于控制动画区间内的值如何变化
        animator.setEvaluator(new IntEvaluator());//Evaluator转换器
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(curValue,curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //动画结束
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                //动画被取消
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                //动画重复
            }
        });
        animator.start();
//        animator.cancel();此方法可以停止动画
//        animator.removeAllListeners();此方法用于去除所有监听
//        animator.clone();克隆出一个一模一样的ValuesAnimator
        return animator;
    }
}
