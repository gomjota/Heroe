package com.github.juan1393.heroe.domain.response;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class Response<T> {

    T data;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
