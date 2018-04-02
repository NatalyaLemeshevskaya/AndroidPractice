package com.natallialemiasheuskaya.data.repository;

import com.natallialemiasheuskaya.data.entity.Image;
import com.natallialemiasheuskaya.data.net.RestService;
import com.natallialemiasheuskaya.domain.entity.ImageEntity;
import com.natallialemiasheuskaya.domain.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public class ImageRepositoryImpl implements ImageRepository{


    private RestService restService;

    @Inject
    public ImageRepositoryImpl( RestService restService) {
        this.restService = restService;
    }


    @Override
    public Observable<List<ImageEntity>> searchImage(String search) {
        return restService.searchImage(search).map(new Function<List<Image>, List<ImageEntity>>() {
            @Override
            public List<ImageEntity> apply(List<Image> images) throws Exception {
                List<ImageEntity> list = new ArrayList<>();
                for(Image i:images){
                    list.add(new ImageEntity(i.getImages().getOriginal().getUrl()));
                }

                return list;
            }
        });
    }

    @Override
    public Observable<List<ImageEntity>> trendingImages() {
        return restService.trendingImages().map(new Function<List<Image>, List<ImageEntity>>() {
            @Override
            public List<ImageEntity> apply(List<Image> images) throws Exception {

                List<ImageEntity> list = new ArrayList<>();
                for(Image i:images){
                    list.add(new ImageEntity(i.getImages().getOriginal().getUrl()));
                }

                return list;
            }
        });
    }
}
