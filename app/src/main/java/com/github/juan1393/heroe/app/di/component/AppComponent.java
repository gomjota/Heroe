package com.github.juan1393.heroe.app.di.component;

import android.app.Application;

import com.github.juan1393.heroe.Heroe;
import com.github.juan1393.heroe.app.di.module.AppModule;
import com.github.juan1393.heroe.app.executor.MainThread;
import com.github.juan1393.heroe.app.executor.UseCaseExecutor;
import com.github.juan1393.heroe.app.navigator.Navigator;
import com.github.juan1393.heroe.data.http.HttpDataSource;
import com.github.juan1393.heroe.domain.repository.ComicRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Juan Gómez on 11/2/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Heroe app);

    Application application();

    UseCaseExecutor threadExecutor();

    MainThread mainThread();

    HttpDataSource httpDataSource();

    ComicRepository comicRepository();

    Navigator navigator();
}