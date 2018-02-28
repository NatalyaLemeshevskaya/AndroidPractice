package com.natallialemiasheuskaya.homework6;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoader {

    //Константы адресов
    private final String URL_JSON = "http://kiparo.ru/t/shop.json";

    public void loader(Context context) throws IOException {
        try {
            URL url = new URL("http://kiparo.ru/t/shop.json");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                 InputStream inputStream = connection.getInputStream();

                File file = new File(context.getFilesDir(), "goods.json");

                FileOutputStream streamOut = new FileOutputStream(file);


                    byte[] buffer = new byte[2048];
                    int read;
                    while ((read = inputStream.read(buffer)) != -1) {
                        streamOut.write(buffer, 0, read);
                    }
                } else {
                return;
            }
        } catch (IOException e) {
            e.getMessage();
            return;
        }
    }

}
