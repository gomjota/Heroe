package com.github.juan1393.heroe.data.http.request;

import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.data.exception.NetworkServiceException;
import com.github.juan1393.heroe.data.http.manager.HttpManager;
import com.github.juan1393.heroe.domain.response.Response;

import retrofit2.Call;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class HttpBaseRequest<T> {

    private Call<T> call;

    protected Response<T> execute(Call<T> call)
            throws NetworkConnectionException, NetworkServiceException {
        this.call = call;
        return HttpManager.execute(this);
    }

    public abstract Response<T> run() throws NetworkConnectionException, NetworkServiceException;

    public Call<T> getCall() {
        return call;
    }
}
