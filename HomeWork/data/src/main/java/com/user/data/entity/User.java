package com.user.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by natallialemiasheuskaya on 19.03.2018.
 */

public class User {

    @SerializedName("objectId")
    private String objectId;
    private String userName;
    private int age;
    private String profileUrl;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
