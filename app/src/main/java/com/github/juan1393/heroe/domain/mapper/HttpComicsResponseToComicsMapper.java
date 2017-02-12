package com.github.juan1393.heroe.domain.mapper;

import android.util.Log;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.data.http.model.HttpResult;
import com.github.juan1393.heroe.data.http.response.HttpGetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpComicsResponseToComicsMapper implements Mapper<HttpGetCharacterComicsResponse, List<Comic>> {

    private final String TAG = "HttpComicResponseMapper";
    private HttpResultToComicMapper httpResultToComicMapper;

    public HttpComicsResponseToComicsMapper() {
        httpResultToComicMapper = new HttpResultToComicMapper();
    }

    @Override
    public List<Comic> map(HttpGetCharacterComicsResponse input) {
        List<Comic> comics = new ArrayList<>();
        try {
            comics = getComics(input);
        } catch (InfoNotAvailableException e) {
            Log.d(TAG, "Info is not available");
        }

        return comics;
    }

    private List<Comic> getComics(HttpGetCharacterComicsResponse input) throws InfoNotAvailableException {
        if(input.getData() != null && input.getData().getResults() != null) {
            List<Comic> comics = new ArrayList<>();
            for(HttpResult httpResult : input.getData().getResults()) {
                comics.add(httpResultToComicMapper.map(httpResult));
            }
            return comics;
        }

        throw new InfoNotAvailableException();
    }
}
