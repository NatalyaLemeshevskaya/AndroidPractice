package com.natallialemiasheuskaya.data.net;


import com.natallialemiasheuskaya.data.entity.Data;
import com.natallialemiasheuskaya.data.entity.Image;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.http.Path;

@Singleton
public class RestService {

    private RestApi restApi;


    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<List<Image>> searchImage(String search){
        return restApi.searchImage(search)
                .map(new Function<Data, List<Image>>() {
                    @Override
                    public List<Image> apply(Data data) throws Exception {
                        return data.getList();
                    }
                });
    }

    public Observable<List<Image>> trendingImages(){
        return restApi.trendingImage().map(new Function<Data, List<Image>>() {
            @Override
            public List<Image> apply(Data data) throws Exception {
                return data.getList();
            }
        });
    }

}
