package com.codecool.wupapplication.main;

import com.codecool.wupapplication.model.Card;
import com.codecool.wupapplication.model.CardAdapter;
import com.codecool.wupapplication.model.ResponseCards;
import com.codecool.wupapplication.network.BaseApiService;
import com.codecool.wupapplication.network.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CardPresenter implements CardContract.Presenter {

    private CardContract.View mView;
    BaseApiService mApiService;
    List<Card> cardList = new ArrayList<>();

    public CardPresenter(CardContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
        mApiService = UtilsApi.getAPIService();
    }

    @Override
    public void requestCards() {
        mApiService.requestCards()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ResponseCards>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ResponseCards> responseCards) {
                        for (ResponseCards resCard : responseCards) {
                            cardList.add(CardAdapter.convertResponseCardToCard(resCard));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgress();
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgress();
                        mView.showCardFragments(cardList);
                    }
                });
    }

    @Override
    public void onDetach() {
        mView = null;
    }
}
