package com.github.juan1393.heroe.app.executor;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public interface MainThread {
    void post(final Runnable runnable);
}
