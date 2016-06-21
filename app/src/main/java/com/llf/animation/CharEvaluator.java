package com.llf.animation;

import android.animation.TypeEvaluator;

/**
 * Created by llf on 2016/6/21.
 * 自定义的Evaluator,Evaluator必须与设置的取值范围类型一样
 */
public class CharEvaluator implements TypeEvaluator<Character>{
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
