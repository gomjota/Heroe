package com.github.juan1393.heroe.domain.useCase;

import com.github.juan1393.heroe.app.executor.MainThread;
import com.github.juan1393.heroe.app.executor.UseCaseExecutor;
import com.github.juan1393.heroe.domain.request.BaseRequest;
import com.github.juan1393.heroe.domain.response.BaseResponse;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class BaseUseCase<R extends BaseRequest, C extends BaseResponse> {

    protected UseCaseExecutor executor;
    protected MainThread mainThread;

    protected R request;
    protected C response;

    public BaseUseCase(UseCaseExecutor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    public void execute(R request, C response) {
        this.request = request;
        this.response = response;
        executor.run(this);
    }

    public abstract void run();
}
