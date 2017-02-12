package com.github.juan1393.heroe.data.http.response;

import com.github.juan1393.heroe.data.http.model.HttpData;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpGetCharacterComicsResponse {

    @SerializedName("data")
    private HttpData data;

    public HttpData getData() {
        return data;
    }
}
