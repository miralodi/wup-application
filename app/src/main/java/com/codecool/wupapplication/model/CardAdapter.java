package com.codecool.wupapplication.model;

import com.codecool.wupapplication.util.DateFormatter;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter {

    public static Card convertResponseCardToCard(ResponseCards resCard) {
        return new Card(
                resCard.getCardId(),
                resCard.getCardNumber(),
                resCard.getCardHolderName(),
                resCard.getCurrency(),
                resCard.getAvailableBalance(),
                resCard.getCurrentBalance(),
                resCard.getMinPayment(),
                DateFormatter.formatDateString(resCard.getDueDate()),
                resCard.getReservations(),
                resCard.getBalanceCarriedOverFromLastStatement(),
                resCard.getSpendingsSinceLastStatement(),
                DateFormatter.formatDateString(resCard.getYourLastRepayment()),
                resCard.getAccountDetails(),
                resCard.getCardImage()
        );
    }

    public static List<Card> getCards(List<ResponseCards> responseCards) {
        List<Card> cardList = new ArrayList<>();

        for (ResponseCards resCard : responseCards) {
            cardList.add(CardAdapter.convertResponseCardToCard(resCard));
        }

        return cardList;
    }
}
