package com.user.domain.entity;

/**
 * Created by natallialemiasheuskaya on 12.03.2018.
 */

public class UserEntity {

    private String userName;
    private int age;
    private String profileUrl;

    public UserEntity() {
    }

    public UserEntity(String userName, int age, String profileUrl) {
        this.userName = userName;
        this.age = age;
        this.profileUrl = profileUrl;
    }

    public  String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
