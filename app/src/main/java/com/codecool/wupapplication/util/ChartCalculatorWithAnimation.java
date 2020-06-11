package com.codecool.wupapplication.util;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;

public class ChartCalculatorWithAnimation {

    private static final int ANIMATION_DURATION = 1000;
    private static final int PERCENTAGE = 100;

    public static void calculateChart(int chartLength, int availableBalance, int currentBalance, View mChartAvailable) {
        double maxValue = availableBalance + currentBalance;
        double percentage = availableBalance * PERCENTAGE / maxValue;

        setWidthAnimation(mChartAvailable, mChartAvailable.getLayoutParams().width, (int) Math.round(chartLength * (percentage / PERCENTAGE)));

        mChartAvailable.setVisibility(View.VISIBLE);
        mChartAvailable.requestLayout();
    }

    private static void setWidthAnimation(final View view, int currentWidth, int newWidth) {
        ValueAnimator slideAnimator = ValueAnimator
                .ofInt(currentWidth, newWidth)
                .setDuration(ANIMATION_DURATION);

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
