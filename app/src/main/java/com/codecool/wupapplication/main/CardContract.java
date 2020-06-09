package com.codecool.wupapplication.main;

import com.codecool.wupapplication.BasePresenter;
import com.codecool.wupapplication.BaseView;
import com.codecool.wupapplication.model.Card;

import java.util.List;

public interface CardContract {

    interface Presenter extends BasePresenter {

        void requestCards();
    }

    interface View extends BaseView<Presenter> {

        void showCardFragments(List<Card> cards);

        void showProgress();

        void hideProgress();
    }
}
