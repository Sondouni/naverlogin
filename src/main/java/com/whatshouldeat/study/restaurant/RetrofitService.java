package com.whatshouldeat.study.restaurant;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RetrofitService {
    @GET("kor/api/tasty.html?mode=json&addr=%EC%A4%91%EA%B5%AC")
    Call<DMBodyVO> getRestList();

    @GET("openapi/tourInfo/food.do")
    Call<IMBodyVO> getICMJList();
}
