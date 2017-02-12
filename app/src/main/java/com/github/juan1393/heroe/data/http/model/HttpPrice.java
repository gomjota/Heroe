package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpPrice {

    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private float price;

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}
