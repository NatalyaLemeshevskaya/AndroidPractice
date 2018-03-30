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

public class SearchUseCase extends BaseUseCase {

    private ImageRepository imageRepository;

    @Inject
    public SearchUseCase(PostExecutionThread postExecutionThread,
                         ImageRepository imageRepository) {
        super(postExecutionThread);
        this.imageRepository = imageRepository;
    }

    public Observable<List<ImageEntity>> searchImage(String search){

        return imageRepository
                .searchImage(search)
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }
}
