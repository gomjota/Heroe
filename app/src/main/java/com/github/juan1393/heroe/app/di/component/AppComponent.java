package com.github.juan1393.heroe.app.di.component;

import com.github.juan1393.heroe.Heroe;
import com.github.juan1393.heroe.app.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Juan Gómez on 11/2/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Heroe app);
}