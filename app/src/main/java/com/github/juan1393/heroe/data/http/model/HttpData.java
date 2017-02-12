package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpData {

    @SerializedName("offset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<HttpResult> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<HttpResult> getResults() {
        return results;
    }
}
