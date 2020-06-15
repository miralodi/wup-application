package com.codecool.wupapplication.network;

import com.codecool.wupapplication.model.ResponseCards;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BaseApiService {

    @GET("wupdigital/interview-api/master/api/v1/cards.json")
    Observable<List<ResponseCards>> requestCards();
}
