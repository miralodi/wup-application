package com.codecool.wupapplication.main;

import com.codecool.wupapplication.model.Card;
import com.codecool.wupapplication.model.CardAdapter;
import com.codecool.wupapplication.model.ResponseCards;
import com.codecool.wupapplication.network.BaseApiService;
import com.codecool.wupapplication.network.UtilsApi;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CardPresenter implements CardContract.Presenter {

    private CardContract.View mView;
    BaseApiService mApiService;

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
                .subscribe(new SingleObserver<List<ResponseCards>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ResponseCards> responseCards) {
                        List<Card> resultCards = CardAdapter.getCards(responseCards);
                        mView.showCardFragments(resultCards);
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                        mView.hideProgress();
                    }

                });
    }

    @Override
    public void onDetach() {
        mView = null;
    }
}
