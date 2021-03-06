package com.winthan.ybs.utils;

import android.content.Context;

import com.winthan.ybs.YBSApp;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by winthanhtike on 7/7/16.
 */
public class JsonUtils {

    private static String PATH_ITEM_DATA = "data";

    private static JsonUtils objInstance;

    private Context context;

    public static JsonUtils getInstance(){
        if (objInstance == null){
            objInstance = new JsonUtils();
        }
        return objInstance;
    }

    private JsonUtils(){
        context = YBSApp.getContext();
    }

    private byte[] readJsonFile(String filename) throws IOException {
        InputStream inStream = context.getAssets().open(filename);
        int size = inStream.available();
        byte[] buffer = new byte[size];
        inStream.read(buffer);
        inStream.close();
        return buffer;
    }

    public String loadBasicItemData(String filename) throws IOException {
        byte[] buffer = readJsonFile(PATH_ITEM_DATA + "/" + filename);
        return new String(buffer,"UTF-8").toString();
    }

}
