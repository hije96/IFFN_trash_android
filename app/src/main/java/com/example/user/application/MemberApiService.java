package com.example.user.application;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by User on 2017-01-05.
 */

public interface MemberApiService {
    public static final String API_URL = "http:172.20.10.11:3000/";
    //   @FormUrlEncoded
    @POST("sign")
    Call<MemberResponseJson> getComment(@Body MemberDataModel MemberdataModel);
}
