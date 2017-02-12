package com.github.juan1393.heroe.domain.repository;

import com.github.juan1393.heroe.data.http.HttpDataSource;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class BaseRepository {

    protected HttpDataSource httpDataSource;

    public BaseRepository(HttpDataSource httpDataSource) {
        this.httpDataSource = httpDataSource;
    }
}
