package com.codecool.wupapplication.model;

import com.google.gson.annotations.SerializedName;

public class AccountDetails {

    @SerializedName("accountLimit")
    private int accountLimit;

    @SerializedName("accountNumber")
    private String accountNumber;
}
