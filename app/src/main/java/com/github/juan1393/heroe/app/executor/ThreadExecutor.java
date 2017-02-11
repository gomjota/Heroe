package com.github.juan1393.heroe.app.executor;

import com.github.juan1393.heroe.domain.useCase.BaseUseCase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class ThreadExecutor implements UseCaseExecutor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public ThreadExecutor() {
        threadPoolExecutor =
                new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
                        WORK_QUEUE);
    }

    @Override
    public void run(final BaseUseCase baseUseCase) {
        if (baseUseCase == null) {
            throw new IllegalArgumentException("Interactor must not be null");
        }

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                baseUseCase.run();
            }
        });
    }
}
