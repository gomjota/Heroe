package com.github.juan1393.heroe;

import android.app.Application;

import com.github.juan1393.heroe.app.di.component.AppComponent;
import com.github.juan1393.heroe.app.di.component.DaggerAppComponent;
import com.github.juan1393.heroe.app.di.module.AppModule;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class Heroe extends Application {

    private AppComponent appComponent;
    private static Heroe instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        setupInjection();
    }

    private void setupInjection() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static Heroe getInstance() {
        return instance;
    }
}
