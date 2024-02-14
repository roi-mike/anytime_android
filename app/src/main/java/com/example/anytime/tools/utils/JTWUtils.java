package com.example.anytime.tools.utils;

import android.util.Base64;
import android.util.Log;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class JTWUtils {

        public static JSONObject decoded(String JWTEncoded) throws Exception {
            try {
                String[] split = JWTEncoded.split("\\.");
                Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
                Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
                return new JSONObject(getJson(split[1]));
            } catch (UnsupportedEncodingException e) {
                //Error
            }
            return new JSONObject(JWTEncoded);
        }

        private static String getJson(String strEncoded) throws UnsupportedEncodingException{
            byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
            return new String(decodedBytes, "UTF-8");
        }
}
