package com.natallialemiasheuskaya.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public class Image {

    @SerializedName("url")
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
