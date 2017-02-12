package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpCreators {

    @SerializedName("items")
    private List<HttpCreator> creators;

    public List<HttpCreator> getCreators() {
        return creators;
    }
}
