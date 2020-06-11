package com.codecool.wupapplication.util;

import java.text.NumberFormat;

public class CurrencyFormatter {

    public static String formatIntToCurrency(int input) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMinimumFractionDigits(2);
        return format.format(input).replaceFirst(",", "’");
    }
}
