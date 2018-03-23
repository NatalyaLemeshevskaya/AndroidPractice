package com.user.domain.interactors;



import com.user.domain.entity.UserEntity;
import com.user.domain.executor.PostExecutionThread;
import com.user.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class GetUserByIdUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread,
                              @Named("repository1") UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id){

        return userRepository
                .get(id)
                .subscribeOn(threadExecution )
                .observeOn(postExecutionThread);


    }


}
