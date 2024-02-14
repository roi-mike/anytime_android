package com.example.anytime.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anytime.pages.CheckLoginForBtnConnection;
import com.example.anytime.pages.TopicsLearnActivity;
import com.example.anytime.services.managers.TokenManager;
import com.example.anytime.tools.animationtools.SinglettonConnectionChecker;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationServices {

    private TokenManager tokenManager;

    private SinglettonConnectionChecker singlettonConnectionChecker;

    public void savaregisternewcustomer(Context context, String data_request){

        Log.d("SAVE REGISTER SERVICE ", String.valueOf(data_request));

        String Register_URL = "http://192.168.1.15:3000/authentication/saveregistercustomer";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Register_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    //TODO
                    //Intent intent = new Intent(context, TopicsLearnActivity.class);
                    //context.startActivity(intent);
                    //((Activity) context).finish();
                } else {
                    Toast.makeText(context, "Invalid Login Id/Password", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("data", data_request);
                return data;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void checkloginconnection(Context context, String data_request){

        //METTRE LE sharedPreferences va me service à enregistrer des variable localement
        //SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();

        tokenManager = TokenManager.getInstance(context);

        singlettonConnectionChecker = SinglettonConnectionChecker.getInstance();

        String login_URL = "http://192.168.1.15:3000/authentication/checkloginconnection";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (!response.isEmpty()) {
                    //ICI j'enregistrerm avec la fonction set apply
                    //String reptoken = response.toString();
                    //editor.putString(TOKEN_CLIENT, reptoken);
                    //editor.apply();


                    tokenManager.setToken(response.toString());

                    //Log.d("91 LOCALSTOCKAGE ", sharedPreferences.getString(TOKEN_CLIENT, ""));

                    singlettonConnectionChecker.setSinglettonConnectionChecker(CheckLoginForBtnConnection.LOGIN);


                    Log.d("TOkEN ", tokenManager.getToken());
                    Intent intent = new Intent(context, TopicsLearnActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "Invalid Login Id/Password", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                //data.put("Authorization", ACCESS_TOKEN);
                data.put("data", data_request);
                return data;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
