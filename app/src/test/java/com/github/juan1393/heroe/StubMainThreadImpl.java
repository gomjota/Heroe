package com.github.juan1393.heroe;

import com.github.juan1393.heroe.app.executor.MainThread;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class StubMainThreadImpl implements MainThread {

    @Override
    public void post(Runnable runnable) {
        runnable.run();
    }
}
