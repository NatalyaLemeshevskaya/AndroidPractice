package com.natallialemiasheuskaya.data.net;


import com.natallialemiasheuskaya.data.entity.Constants;
import com.natallialemiasheuskaya.data.entity.Data;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestApi {


    @GET("v1/gifs/search")
    @Headers("api-key: q3qDJ2Htpy8a6wLxrDlM9cGrc60pP86j")
    Observable<Data> searchImage(@Query("q")String search);

    @GET("v1/gifs/trending")
    @Headers("api-key: q3qDJ2Htpy8a6wLxrDlM9cGrc60pP86j")
    Observable<Data> trendingImage();


}


