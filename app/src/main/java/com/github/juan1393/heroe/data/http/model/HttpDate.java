package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpDate {

    @SerializedName("type")
    private String type;

    @SerializedName("date")
    private Date date;

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
}
