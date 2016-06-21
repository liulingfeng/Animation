package com.llf.animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by llf on 2016/6/21.
 * ObjectAnimator是派生自ValueAnimator的
 *
 * ofInt(0,400)-->插值器（返回数值进度）-->Evaluator(根据数值进度计算当前值)-->调用Set函数
 */
public class ObjectAnimatorActivity extends Activity{
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        tv = (TextView)findViewById(R.id.tv);
    }

    public void start(View v){
        doAnimation();
    }

    /**
     第一个参数用于指定这个动画要操作的是哪个控件
     第二个参数用于指定这个动画要操作这个控件的哪个属性,其实就是控件的Set方法
     第三个参数是可变长参数，这个就跟ValueAnimator中的可变长参数的意义一样了，就是指这个属性值是从哪变到哪

     1、要使用ObjectAnimator来构造对画，要操作的控件中，必须存在对应的属性的set方法
     2、set 方法的命名必须以骆驼拼写法命名，即set后每个单词首字母大写，其余字母小写，即类似于setPropertyName所对应的属性为propertyName
     */
    private void doAnimation(){
        //注意Set函数中值得类型
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
        objectAnimator.setDuration(2000);
        objectAnimator.start();

        /**
         还有一种构造方法是用PropertyValuesHolder
         PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
         PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
         ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mTextView, rotationHolder, colorHolder);
         animator.setDuration(3000);
         animator.setInterpolator(new AccelerateInterpolator());
         animator.start();
         */

        //除了Evaluator和插值器。另外一种控制速率的方法是用Keyframe（关键帧）
        /**
         fraction：表示当前的显示进度，即从加速器中getInterpolation()函数的返回值；
         value：表示当前应该在的位置
         */
//        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
//        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
//        frame1.setInterpolator(new BounceInterpolator());
//        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
//        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
//        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
//        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
//        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
//        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
//        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
//        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
//        Keyframe frame10 = Keyframe.ofFloat(1, 0);
//        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10);
//
//        Animator animator = ObjectAnimator.ofPropertyValuesHolder(tv,frameHolder);
//        animator.setDuration(1000);
//        animator.start();
    }
}
