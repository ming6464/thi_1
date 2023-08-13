package com.fpoly.thi_test1.API;

import com.fpoly.thi_test1.DTO.SinhVien;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API_SinhVien {

    static final String Router = "/sinhvien";
    @POST(Router + "/create")
    Call<Integer> CreateElement(@Body SinhVien sinhVien);

    @GET(Router + "/")
    Call<List<SinhVien>> GetAll();

    @GET(Router + "/{msv}")
    Call<SinhVien> GetElement(@Path("msv") String msv);

    @POST(Router + "/update/{msv}")
    Call<Integer> UpdateElement(@Path("msv") String msv, @Body SinhVien sinhVien);

    @POST(Router + "/delete/{msv}")
    Call<Integer> DeleteElement(@Path("msv") String msv);

    @POST(Router + "/delete")
    Call<Integer> DeleteAll();

}
