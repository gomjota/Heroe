package com.github.juan1393.heroe.app.di.module;

import android.app.Application;

import com.github.juan1393.heroe.app.executor.MainThread;
import com.github.juan1393.heroe.app.executor.MainThreadImpl;
import com.github.juan1393.heroe.app.executor.ThreadExecutor;
import com.github.juan1393.heroe.app.executor.UseCaseExecutor;
import com.github.juan1393.heroe.app.navigator.Navigator;
import com.github.juan1393.heroe.data.http.HttpDataSource;
import com.github.juan1393.heroe.domain.repository.ComicRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juan Gómez on 11/2/17.
 */

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    UseCaseExecutor provideThreadExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Singleton
    MainThread providePostExecutionThread() {
        return new MainThreadImpl();
    }

    @Provides
    @Singleton
    ComicRepository provideComicRepository(HttpDataSource httpDataSource) {
        return new ComicRepository(httpDataSource);
    }

    @Provides
    @Singleton
    HttpDataSource provideHttpDataSource() {
        return new HttpDataSource();
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }
}
