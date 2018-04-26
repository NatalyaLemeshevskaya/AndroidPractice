package com.natallialemiasheuskaya.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.natallialemiasheuskaya.data.entity.Coin;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    @TypeConverter
    public static List<Coin> fromString(String value) {
        Type listType = new TypeToken<List<Coin>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<Coin> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
