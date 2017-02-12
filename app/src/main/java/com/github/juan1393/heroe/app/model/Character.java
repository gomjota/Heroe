package com.github.juan1393.heroe.app.model;

import java.io.Serializable;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class Character implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
