package com.example.recyclerview.data;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
public class JsonReader {
    protected static String jsonToString(Context context) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open("covid_all.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String charSet = "UTF-8";
            jsonString = new String(buffer, charSet);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
}