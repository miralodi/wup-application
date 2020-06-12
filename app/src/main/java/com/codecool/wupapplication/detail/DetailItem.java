package com.codecool.wupapplication.detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.codecool.wupapplication.R;

public class DetailItem extends ConstraintLayout {

    private String labelText;
    private String currencyText;
    private String valueText;
    private boolean showYellow;

    TextView labelTv;
    TextView currencyTv;
    TextView valueTv;

    public DetailItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DetailItem,
                0, 0);

        try {
            labelText = a.getString(R.styleable.DetailItem_labelText);
            currencyText = a.getString(R.styleable.DetailItem_currencyText);
            valueText = a.getString(R.styleable.DetailItem_valueText);
        } finally {
            a.recycle();
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        inflater.inflate(R.layout.detail_item_layout, this, true);

        labelTv = findViewById(R.id.label);
        labelTv.setText(labelText);
        valueTv = findViewById(R.id.value);
        valueTv.setText(valueText);
        currencyTv = findViewById(R.id.currency);
        currencyTv.setText(currencyText);
    }

    public DetailItem(Context context) {
        super(context);
    }

    public DetailItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
        labelTv.setText(labelText);
        invalidate();
        requestLayout();
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
        valueTv.setText(valueText);
        invalidate();
        requestLayout();
    }

    public void setCurrencyText(String currencyText) {
        this.currencyText = currencyText;
        currencyTv.setText(currencyText);
        invalidate();
        requestLayout();
    }
}
