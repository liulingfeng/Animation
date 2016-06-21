package com.llf.animation;

import android.animation.TimeInterpolator;

/**
 * Created by llf on 2016/6/21.
 * 自定义一个插值器
 */

public class CustomInterpolator implements TimeInterpolator{
    /**
     *
     * @param input 当前的时间进度
     *  返回值是想要返回的数值进度
     *  当前这个就相当于一个LinearInterpolator,返回的数值进度就是当前的时间进度
     */
    @Override
    public float getInterpolation(float input) {
        return input;
    }
}
