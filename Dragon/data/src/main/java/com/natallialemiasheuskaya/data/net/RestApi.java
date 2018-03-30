package com.natallialemiasheuskaya.data.net;


import com.natallialemiasheuskaya.data.entity.Constants;
import com.natallialemiasheuskaya.data.entity.Data;
import com.natallialemiasheuskaya.data.entity.Image;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestApi {


    @GET("v1/gifts/search")
    @Headers("Dragon: "+Constants.API_IMAGE_KEY)
    Observable<Data> searchImage(@Query("q")String search);

    @GET("v1/gifts/trending")
    @Headers("Dragon: "+Constants.API_IMAGE_KEY)
    Observable<Data> trendingImage();


}


