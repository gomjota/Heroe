package com.github.juan1393.heroe.data.http.service;

import com.github.juan1393.heroe.BuildConfig;
import com.github.juan1393.heroe.data.http.response.HttpGetCharacterComicsResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public interface MarvelService {

    @GET("/v1/public/characters/{characterId}/comics")
    Call<HttpGetCharacterComicsResponse> characterComics(@Path("characterId") int characterId,
                                                         @QueryMap Map<String, Object> params);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_PUBLIC_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
