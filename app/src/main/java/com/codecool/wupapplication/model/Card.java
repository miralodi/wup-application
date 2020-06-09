package com.codecool.wupapplication.model;

import java.util.Date;

public class Card {

    private int cardId;

    private String cardNumber;

    private String cardHolderName;

    private String currency;

    private int availableBalance;

    private int currentBalance;

    private int minPayment;

    private Date dueDate;

    private int reservations;

    private int balanceCarriedOverFromLastStatement;

    private int spendingsSinceLastStatement;

    private Date yourLastRepayment;

    private AccountDetails accountDetails;

    private int cardImage;

    public Card(int cardId,
                String cardNumber,
                String cardHolderName,
                String currency,
                int availableBalance,
                int currentBalance,
                int minPayment,
                Date dueDate,
                int reservations,
                int balanceCarriedOverFromLastStatement,
                int spendingsSinceLastStatement,
                Date yourLastRepayment,
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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

    public Date getYourLastRepayment() {
        return yourLastRepayment;
    }

    public void setYourLastRepayment(Date yourLastRepayment) {
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
}
