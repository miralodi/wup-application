package com.codecool.wupapplication.util;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;

public class ChartCalculatorWithAnimation {

    public static void calculateChart(int chartLength, int availableBalance, int currentBalance, View mChartAvailable) {
        double maxValue = availableBalance + currentBalance;
        double percentage = availableBalance * 100 / maxValue;

        setWidthAnimation(mChartAvailable, mChartAvailable.getLayoutParams().width, (int) Math.round(chartLength * (percentage / 100)));

        mChartAvailable.setVisibility(View.VISIBLE);
        mChartAvailable.requestLayout();
    }

    private static void setWidthAnimation(final View view, int currentHeight, int newHeight) {
        ValueAnimator slideAnimator = ValueAnimator
                .ofInt(currentHeight, newHeight)
                .setDuration(1000);

        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                            @Override
                                            public void onAnimationUpdate(ValueAnimator animation) {
                                                view.getLayoutParams().width = (Integer) animation.getAnimatedValue();

                                                view.requestLayout();
                                            }
                                        }
        );

        AnimatorSet set = new AnimatorSet();
        set.play(slideAnimator);
        set.start();
    }
}
