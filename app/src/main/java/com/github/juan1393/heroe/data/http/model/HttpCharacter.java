package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class HttpCharacter {

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("name")
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }
}