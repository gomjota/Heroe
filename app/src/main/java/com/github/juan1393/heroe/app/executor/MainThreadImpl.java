package com.github.juan1393.heroe.app.executor;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
