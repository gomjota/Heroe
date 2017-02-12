package com.github.juan1393.heroe.data.http.manager;

import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.data.exception.NetworkServiceException;
import com.github.juan1393.heroe.data.http.request.HttpBaseRequest;
import com.github.juan1393.heroe.domain.response.Response;

import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpManager {

    public static <R> Response<R> execute(HttpBaseRequest<R> httpBaseRequest)
            throws NetworkConnectionException, NetworkServiceException {
        retrofit2.Response<R> httpResponse;
        try {
            httpResponse = httpBaseRequest.getCall().execute();
        } catch (ConnectException | UnknownHostException e) {
            throw new NetworkConnectionException();
        } catch (Exception e) {
            throw new NetworkServiceException();
        }

        if (httpResponse != null && httpResponse.isSuccessful()) {
            return new Response<>(httpResponse.body());
        }

        throw new NetworkServiceException();
    }
}
