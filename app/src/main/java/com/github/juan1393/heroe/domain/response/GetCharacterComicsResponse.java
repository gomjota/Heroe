package com.github.juan1393.heroe.domain.response;

import com.github.juan1393.heroe.app.model.Comic;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public interface GetCharacterComicsResponse extends BaseResponse {

    void onCharacterComicsRetrieved(List<Comic> comics);

    void onCharacterComicsNotFound();

    void onNetworkConnectionError();
}
