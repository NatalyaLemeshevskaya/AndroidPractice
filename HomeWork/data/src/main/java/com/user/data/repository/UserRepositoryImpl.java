package com.user.data.repository;


import android.content.Context;


import com.user.data.entity.User;
import com.user.data.net.RestService;
import com.user.domain.entity.UserEntity;
import com.user.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository {


    private Context context;
    private RestService restService;

    public UserRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<UserEntity> get(String id) {

        return restService.loadUserById(id)
                .map(new Function<User, UserEntity>() {
                    @Override

                    public UserEntity apply(User user) throws Exception {
                        return new UserEntity(user.getUserName(),
                                user.getAge(),
                                user.getProfileUrl(),user.getObjectId());
                    }
                });
    }




    @Override
    public Observable<List<UserEntity>> get() {
        return restService
                .loadUsers()
                .map(new Function<List<User>, List<UserEntity>>() {
            @Override
            public List<UserEntity> apply(List<User> users) throws Exception {

                List<UserEntity> list = new ArrayList<>();
                for(User user: users){
                    list.add(new UserEntity(user.getUserName(),
                            user.getAge(),user.getProfileUrl(),user.getObjectId()));
                }
                return list;
            }
        });
    }

    @Override
    public Completable save(UserEntity userEntity) {
        User user = new User();
        user.setUserName(userEntity.getUserName());
        user.setProfileUrl(userEntity.getProfileUrl());
        user.setAge(userEntity.getAge());
        user.setObjectId(userEntity.getId());
        return restService.saveUser(user);
    }

    @Override
    public Completable remove(String id) {
        return restService.removeUser(id);
    }
}
