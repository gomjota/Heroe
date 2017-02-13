package com.github.juan1393.heroe.data.http.request;

import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.data.exception.NetworkServiceException;
import com.github.juan1393.heroe.data.http.response.HttpGetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.Response;

import retrofit2.Call;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpGetCharacterComicsRequest
        extends MarvelAuthRequest<HttpGetCharacterComicsResponse> {

    private GetCharacterComicsRequest request;

    public HttpGetCharacterComicsRequest(GetCharacterComicsRequest request) {
        this.request = request;
    }

    @Override
    public Response<HttpGetCharacterComicsResponse> run() throws NetworkConnectionException,
            NetworkServiceException {

        params.put("format", "comic");
        params.put("formatType", "comic");
        params.put("limit", request.getMaxComics());

        Call<HttpGetCharacterComicsResponse> call = service.characterComics(
                request.getCharacterId(), params);
        return execute(call);
    }
}
