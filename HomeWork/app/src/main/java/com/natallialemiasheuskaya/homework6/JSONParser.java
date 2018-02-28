package com.natallialemiasheuskaya.homework6;

import android.content.Context;
import android.provider.DocumentsContract;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natallialemiasheuskaya.homework5.HomeWork5Activity;

import org.xml.sax.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;


public class JSONParser  {


    public Root parse( Context context) {

        Root root = new Root();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(context.getFileStreamPath("goods.json")));
            GsonBuilder builder = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateJsonConverter());
            Gson gson = builder.create();

            root = gson.fromJson(bufferedReader,Root.class);
            Log.e("Root",root.toString());


        } catch (Exception e) {
            System.out.println("Невозможно открыть json  " + e.toString());

        }

        return root;
    }



}