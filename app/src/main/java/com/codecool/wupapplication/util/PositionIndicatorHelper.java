package com.codecool.wupapplication.util;

import android.content.Context;
import android.media.Image;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.codecool.wupapplication.R;

public class PositionIndicatorHelper {

    public static void setDotIndicators(LinearLayout layout, int position, int numOfTabs, Context context) {

        for (int i = 0; i < numOfTabs; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    30,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            params.setMargins(20,0,20,0);
            layout.addView(new ImageView(context), params);
            ((ImageView) layout.getChildAt(i)).setImageDrawable(context.getResources().getDrawable(R.drawable.tab_selector));

            if (i == position) {
                layout.getChildAt(i).setSelected(true);
            } else {
                layout.getChildAt(i).setSelected(false);
            }

            layout.invalidate();
            layout.requestLayout();
        }
    }
}
