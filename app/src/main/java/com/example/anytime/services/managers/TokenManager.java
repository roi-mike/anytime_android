package com.example.anytime.services.managers;

import android.content.Context;
import android.content.SharedPreferences;


public class TokenManager {
    private static final String TOKEN_CLIENT = "TOKEN_CLIENT";
    private static TokenManager instance;
    private SharedPreferences sharedPreferences;

    private TokenManager(Context context) {
        sharedPreferences = context.getSharedPreferences(TOKEN_CLIENT, Context.MODE_PRIVATE);
    }

    public static synchronized TokenManager getInstance(Context context) {
        if (instance == null) {
            instance = new TokenManager(context);
        }
        return instance;
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN_CLIENT, "");
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_CLIENT, token);
        editor.apply();
    }
}
