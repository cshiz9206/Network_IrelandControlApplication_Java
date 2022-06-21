package com.example.irelandcontrollerex;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/list")
    Call<ResponseBody> getFunc(@Query("undefined") String mode);

    @FormUrlEncoded
    @POST("/retrofit/post")
    Call<ResponseBody> postFunc(@Field("cmd") String cmd, @Field("target") String target, @Field("data") String data);

    //@FormUrlEncoded
    @PUT("/put/{cmdType}")
    Call<DataControl> setCmd(@Path("cmdType") String cmdType, @Body DataControl cmd);
    //@Field("command") String command, @Field("targetDevice") String targetDevice, @Field("controlDevice") String controlDevice, @Field("data") String data

    @DELETE("/retrofit/delete/{id}")
    Call<ResponseBody> deleteFunc(@Path("id") String id);
}
