package com.natallialemiasheuskaya.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by natallialemiasheuskaya on 26.03.2018.
 */

public class Data {

    @SerializedName("data")
    private List<Image> list;

    public Data(List<Image> list) {
        this.list = list;
    }

    public List<Image> getList() {
        return list;
    }

    public void setList(List<Image> list) {
        this.list = list;
    }
}
