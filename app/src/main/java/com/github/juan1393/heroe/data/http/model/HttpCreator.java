package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class HttpCreator {

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}