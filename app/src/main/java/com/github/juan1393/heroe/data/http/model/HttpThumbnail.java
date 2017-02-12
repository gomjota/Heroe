package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpThumbnail {

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
