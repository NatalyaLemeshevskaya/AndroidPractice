package com.natallialemiasheuskaya.data.net;

import com.natallialemiasheuskaya.data.entity.Coins;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RestService {

    private RestApi restApi;

    private ErrorTransformers errorTransformers;


    @Inject
    public RestService(RestApi restApi,ErrorTransformers errorTransformers) {
        this.restApi = restApi;
        this.errorTransformers = errorTransformers;
    }

    public Flowable<List<Coins>> tickerList(@Query("limit") int limit){
        return restApi.tickerList(limit)
                .compose(errorTransformers.<List<Coins>, Error>parseHttpError());
    }

    public Flowable<List<Coins>> tickerDetail(@Path("id") String id, @Query("convert") String convert){
        return restApi.tickerDetail(id,convert)
                .compose(errorTransformers.<List<Coins>, Error>parseHttpError());
    }

}
