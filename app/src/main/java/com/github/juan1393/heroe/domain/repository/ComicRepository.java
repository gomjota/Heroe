package com.github.juan1393.heroe.domain.repository;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.data.exception.CharacterComicsNotFoundException;
import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.data.http.HttpDataSource;
import com.github.juan1393.heroe.data.http.response.HttpGetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.mapper.HttpComicsResponseToComicsMapper;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.Response;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class ComicRepository extends BaseRepository {

    private HttpComicsResponseToComicsMapper httpComicsResponseToComicsMapper;

    @Inject
    public ComicRepository(HttpDataSource httpDataSource) {
        super(httpDataSource);
        httpComicsResponseToComicsMapper = new HttpComicsResponseToComicsMapper();
    }

    public Response<List<Comic>> getCharacterComics(GetCharacterComicsRequest getCharacterComicsRequest)
            throws NetworkConnectionException, CharacterComicsNotFoundException {
        Response<HttpGetCharacterComicsResponse> response
                = httpDataSource.getCharacterComics(getCharacterComicsRequest);
        List<Comic> comics = httpComicsResponseToComicsMapper.map(response.getData());
        return new Response<>(comics);
    }
}
