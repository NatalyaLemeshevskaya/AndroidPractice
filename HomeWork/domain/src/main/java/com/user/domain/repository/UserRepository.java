package com.user.domain.repository;

import com.user.domain.entity.UserEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<UserEntity> get(String id);
    Observable<List<UserEntity>> get();
    Completable save(UserEntity userEntity);
    Completable remove(String id);
}
