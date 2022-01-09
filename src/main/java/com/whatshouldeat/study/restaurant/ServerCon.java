package com.whatshouldeat.study.restaurant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerCon {
    private static Retrofit rt;
    private static RetrofitService bs;
    public static RetrofitService getConnect(String url){
        if(rt==null){
            rt = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            bs = rt.create(RetrofitService.class);
        }
        return bs;
    }
}
