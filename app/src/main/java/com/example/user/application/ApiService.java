package com.example.user.application;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by User on 2017-01-05.
 */

public interface ApiService {
 /*   public static final String API_URL = "http://192.168.43.35:3000/";

    @POST("/Flavor")
    Call<ResponseBody> sendflavor(@Body MainActivity.Flavor flavor);
   */

    public static final String API_URL = "http:172.20.10.11:3000/";
    //   @FormUrlEncoded
    @POST("flavor_information")
    Call<ResponseJson> getComment(@Body DataModel dataModel);

 //   @POST("member information")
 //   Call<ResponseJson> getComment(@Body DataModel dataModel);

  /* Call<ResponseBody> getComment(@Query("x") int x,
                                  @Query("y") int y,
                                  @Query("z") int z,
                                  @Query("l") int l);
*/

    //Call<>getPostComment(@Body MainActivity.Flavor);
   // Call<ResponseBody> getComment(@Query("postId") int postId);
}
