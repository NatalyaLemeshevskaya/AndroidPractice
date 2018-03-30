package com.user.domain.interactors;

import com.user.domain.entity.UserEntity;
import com.user.domain.executor.PostExecutionThread;
import com.user.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by natallialemiasheuskaya on 25.03.2018.
 */

public class GetUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetUserUseCase(PostExecutionThread postExecutionThread,
                              UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<UserEntity>> get(){

        return userRepository
                .get()
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }
}
