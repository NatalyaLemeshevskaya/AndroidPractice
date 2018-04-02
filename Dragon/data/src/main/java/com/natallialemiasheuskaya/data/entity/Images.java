package com.natallialemiasheuskaya.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public class Images {

    @SerializedName("original")
    private Original original;

    public Images() {
    }

    public Images(Original original) {
        this.original = original;
    }

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }
}
