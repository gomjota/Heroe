package com.github.juan1393.heroe.data.http.request;

import com.github.juan1393.heroe.data.http.service.MarvelService;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class MarvelRequest<T> extends HttpBaseRequest<T> {

    protected MarvelService service;

    public MarvelRequest() {
        service = MarvelService.retrofit.create(MarvelService.class);
    }
}
