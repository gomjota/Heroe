package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpResult {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("pageCount")
    private int pageCount;

    @SerializedName("dates")
    private List<HttpDate> dates;

    @SerializedName("prices")
    private List<HttpPrice> prices;

    @SerializedName("thumbnail")
    private HttpThumbnail thumbnail;

    @SerializedName("images")
    private List<HttpImage> images;

    @SerializedName("creators")
    private HttpCreators creators;

    @SerializedName("characters")
    private HttpCharacters characters;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List<HttpDate> getDates() {
        return dates;
    }

    public List<HttpPrice> getPrices() {
        return prices;
    }

    public HttpThumbnail getThumbnail() {
        return thumbnail;
    }

    public List<HttpImage> getImages() {
        return images;
    }

    public HttpCreators getCreators() {
        return creators;
    }

    public HttpCharacters getCharacters() {
        return characters;
    }
}
