package com.codecool.wupapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {

    private int cardId;

    private String cardNumber;

    private String cardHolderName;

    private String currency;

    private int availableBalance;

    private int currentBalance;

    private int minPayment;

    private String dueDate;

    private int reservations;

    private int balanceCarriedOverFromLastStatement;

    private int spendingsSinceLastStatement;

    private String yourLastRepayment;

    private AccountDetails accountDetails;

    private int cardImage;

    public Card(int cardId,
                String cardNumber,
                String cardHolderName,
                String currency,
                int availableBalance,
                int currentBalance,
                int minPayment,
                String dueDate,
                int reservations,
                int balanceCarriedOverFromLastStatement,
                int spendingsSinceLastStatement,
                String yourLastRepayment,
                AccountDetails accountDetails,
                int cardImage) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.currency = currency;
        this.availableBalance = availableBalance;
        this.currentBalance = currentBalance;
        this.minPayment = minPayment;
        this.dueDate = dueDate;
        this.reservations = reservations;
        this.balanceCarriedOverFromLastStatement = balanceCarriedOverFromLastStatement;
        this.spendingsSinceLastStatement = spendingsSinceLastStatement;
        this.yourLastRepayment = yourLastRepayment;
        this.accountDetails = accountDetails;
        this.cardImage = cardImage;
    }

    protected Card(Parcel in) {
        cardId = in.readInt();
        cardNumber = in.readString();
        cardHolderName = in.readString();
        currency = in.readString();
        availableBalance = in.readInt();
        currentBalance = in.readInt();
        minPayment = in.readInt();
        dueDate = in.readString();
        reservations = in.readInt();
        balanceCarriedOverFromLastStatement = in.readInt();
        spendingsSinceLastStatement = in.readInt();
        yourLastRepayment = in.readString();
        accountDetails = in.readParcelable(AccountDetails.class.getClassLoader());
        cardImage = in.readInt();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(int minPayment) {
        this.minPayment = minPayment;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }

    public int getBalanceCarriedOverFromLastStatement() {
        return balanceCarriedOverFromLastStatement;
    }

    public void setBalanceCarriedOverFromLastStatement(int balanceCarriedOverFromLastStatement) {
        this.balanceCarriedOverFromLastStatement = balanceCarriedOverFromLastStatement;
    }

    public int getSpendingsSinceLastStatement() {
        return spendingsSinceLastStatement;
    }

    public void setSpendingsSinceLastStatement(int spendingsSinceLastStatement) {
        this.spendingsSinceLastStatement = spendingsSinceLastStatement;
    }

    public String getYourLastRepayment() {
        return yourLastRepayment;
    }

    public void setYourLastRepayment(String yourLastRepayment) {
        this.yourLastRepayment = yourLastRepayment;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public int getCardImage() {
        return cardImage;
    }

    public void setCardImage(int cardImage) {
        this.cardImage = cardImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cardId);
        dest.writeString(cardNumber);
        dest.writeString(cardHolderName);
        dest.writeString(currency);
        dest.writeInt(availableBalance);
        dest.writeInt(currentBalance);
        dest.writeInt(minPayment);
        dest.writeString(dueDate);
        dest.writeInt(reservations);
        dest.writeInt(balanceCarriedOverFromLastStatement);
        dest.writeInt(spendingsSinceLastStatement);
        dest.writeString(yourLastRepayment);
        dest.writeParcelable(accountDetails, flags);
        dest.writeInt(cardImage);
    }
}
