package com.example.architectures.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

//    @Headers("Content-Type: application/json")
//    @POST("add_note.php")
//    Call<Model> add_note(@Body String body);

    @POST("add_note.php")
    @FormUrlEncoded
    Call<Model> add_note(
            @Field("input") String json);

}
