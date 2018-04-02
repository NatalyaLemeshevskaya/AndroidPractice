package com.natallialemiasheuskaya.data.entity;

import com.google.gson.annotations.SerializedName;

public class Original {

    @SerializedName("url")
    private String url;

    public Original() {
    }

    public Original(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
