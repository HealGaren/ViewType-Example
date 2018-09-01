package com.example.healgaren.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfileService {
    @GET("friendListMock.json")
    Call<ResultVo> getMock();
}
