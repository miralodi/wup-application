package com.codecool.wupapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ResponseCards {

    @SerializedName("cardId")
    private int cardId;

    @SerializedName("issuer")
    private String issuer;

    @SerializedName("cardNumber")
    private String cardNumber;

    @SerializedName("expirationDate")
    private String expirationDate;

    @SerializedName("cardHolderName")
    private String cardHolderName;

    @SerializedName("friendlyName")
    private String friendlyName;

    @SerializedName("currency")
    private String currency;

    @SerializedName("cvv")
    private int cvv;

    @SerializedName("availableBalance")
    private int availableBalance;

    @SerializedName("currentBalance")
    private int currentBalance;

    @SerializedName("minPayment")
    private int minPayment;

    @SerializedName("dueDate")
    private String dueDate;

    @SerializedName("reservations")
    private int reservations;

    @SerializedName("balanceCarriedOverFromLastStatement")
    private int balanceCarriedOverFromLastStatement;

    @SerializedName("spendingsSinceLastStatement")
    private int spendingsSinceLastStatement;

    @SerializedName("yourLastRepayment")
    private String yourLastRepayment;

    @SerializedName("accountDetails")
    private AccountDetails accountDetails;

    @SerializedName("status")
    private String status;

    @SerializedName("cardImage")
    private int cardImage;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCardImage() {
        return cardImage;
    }

    public void setCardImage(int cardImage) {
        this.cardImage = cardImage;
    }
}
