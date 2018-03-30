package com.natallialemiasheuskaya.domain.repository;




import com.natallialemiasheuskaya.domain.entity.ImageEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public interface ImageRepository  {

    Observable<List<ImageEntity>> searchImage(String search);

    Observable<List<ImageEntity>> trendingImages();

}
