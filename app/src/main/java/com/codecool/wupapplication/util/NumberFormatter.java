package com.codecool.wupapplication.util;

import java.text.NumberFormat;

public class NumberFormatter {

    public static String formatIntToCurrency(int input) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMinimumFractionDigits(2);
        return format.format(input).replaceFirst(",", "’");
    }

    public static String formatCreditCardNumber(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)) && i < input.length() - 4) {
                result.append("*");
            } else {
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }
}
