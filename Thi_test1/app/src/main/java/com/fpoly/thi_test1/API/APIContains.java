package com.fpoly.thi_test1.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIContains {
    public static final String URL = "http://192.168.11.110:3000/";
    private static API_SinhVien API_SinhVien;
    private static Retrofit retrofit;

    private static Retrofit GetRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static API_SinhVien SINHVIEN(){
        if(API_SinhVien == null){
            API_SinhVien = GetRetrofit().create(API_SinhVien.class);
        }
        return API_SinhVien;
    }

}
