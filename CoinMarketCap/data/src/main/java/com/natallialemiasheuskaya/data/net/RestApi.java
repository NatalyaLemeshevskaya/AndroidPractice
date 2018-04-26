package com.natallialemiasheuskaya.data.net;

import com.natallialemiasheuskaya.data.entity.Coins;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {


    //Call?????
    @GET("v1/ticker/")
    Flowable<List<Coins>> tickerList(@Query("limit") int limit);

    @GET("v1/ticker/{id}/")
    Flowable<List<Coins>> tickerDetail(@Path("id") String id, @Query("convert") String convert);
}
