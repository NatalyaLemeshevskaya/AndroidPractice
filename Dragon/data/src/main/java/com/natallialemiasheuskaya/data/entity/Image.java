package com.natallialemiasheuskaya.data.entity;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("images")
    private Images images;

    public Image(Images images) {
        this.images = images;
    }

    public Image() {
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
