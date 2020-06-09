package com.codecool.wupapplication.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    @SuppressLint("SimpleDateFormat")
    public static String formatDateString(String input) {
        String unifiedInput = input.replaceAll("\\.(?!.*\\.)", "").replaceAll("\\.", "-");
        String result = null;

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date = originalFormat.parse(unifiedInput);
            result = targetFormat.format(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }
}
