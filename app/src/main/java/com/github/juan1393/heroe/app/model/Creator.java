package com.github.juan1393.heroe.app.model;

import java.io.Serializable;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class Creator implements Serializable {

    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
