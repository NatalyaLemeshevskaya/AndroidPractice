package com.natallialemiasheuskaya.domain.interactors;


import com.natallialemiasheuskaya.domain.entity.ImageEntity;
import com.natallialemiasheuskaya.domain.executor.PostExecutionThread;
import com.natallialemiasheuskaya.domain.repository.ImageRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public class TrendingUseCase extends BaseUseCase {

    private ImageRepository imageRepository;

    @Inject
    public TrendingUseCase(PostExecutionThread postExecutionThread,
                           ImageRepository imageRepository) {
        super(postExecutionThread);
        this.imageRepository = imageRepository;
    }

    public Observable<List<ImageEntity>> trendingImages(){

        return imageRepository
                .trendingImages()
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }

}
