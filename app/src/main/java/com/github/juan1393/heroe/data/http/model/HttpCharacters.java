package com.github.juan1393.heroe.data.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpCharacters {

    @SerializedName("items")
    private List<HttpCharacter> characters;

    public List<HttpCharacter> getCharacters() {
        return characters;
    }
}