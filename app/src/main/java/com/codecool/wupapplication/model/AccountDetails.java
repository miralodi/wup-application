package com.codecool.wupapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AccountDetails implements Parcelable {

    @SerializedName("accountLimit")
    private int accountLimit;

    @SerializedName("accountNumber")
    private String accountNumber;

    protected AccountDetails(Parcel in) {
        accountLimit = in.readInt();
        accountNumber = in.readString();
    }

    public static final Creator<AccountDetails> CREATOR = new Creator<AccountDetails>() {
        @Override
        public AccountDetails createFromParcel(Parcel in) {
            return new AccountDetails(in);
        }

        @Override
        public AccountDetails[] newArray(int size) {
            return new AccountDetails[size];
        }
    };

    public int getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(int accountLimit) {
        this.accountLimit = accountLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(accountLimit);
        dest.writeString(accountNumber);
    }
}
