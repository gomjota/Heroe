package com.github.juan1393.heroe.data.http;

import com.github.juan1393.heroe.data.exception.CharacterComicsNotFoundException;
import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.data.exception.NetworkServiceException;
import com.github.juan1393.heroe.data.http.request.HttpGetCharacterComicsRequest;
import com.github.juan1393.heroe.data.http.response.HttpGetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.Response;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpDataSource {

    public Response<HttpGetCharacterComicsResponse> getCharacterComics(GetCharacterComicsRequest request)
            throws NetworkConnectionException, CharacterComicsNotFoundException {
        try {
            return new HttpGetCharacterComicsRequest(request).run();
        } catch (NetworkServiceException e) {
            throw new CharacterComicsNotFoundException();
        }
    }
}
