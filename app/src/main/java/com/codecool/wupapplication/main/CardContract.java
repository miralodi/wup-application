package com.codecool.wupapplication.main;

import com.codecool.wupapplication.BasePresenter;
import com.codecool.wupapplication.BaseView;

public interface CardContract {

    interface Presenter extends BasePresenter {

        void requestCards();
    }

    interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();
    }
}
