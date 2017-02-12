package com.github.juan1393.heroe.app.di.module;

import com.github.juan1393.heroe.app.di.scope.PerView;
import com.github.juan1393.heroe.presentation.ComicDetailPresenter;
import com.github.juan1393.heroe.ui.activity.ComicDetailActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juan Gómez on 12/2/17.
 */

@Module
public class ComicDetailModule {

    private ComicDetailActivity comicDetailActivity;

    public ComicDetailModule(ComicDetailActivity comicDetailActivity) {
        this.comicDetailActivity = comicDetailActivity;
    }

    @Provides
    @PerView
    ComicDetailActivity provideActivity() {
        return comicDetailActivity;
    }

    @Provides
    @PerView
    ComicDetailPresenter providePresenter() {
        return new ComicDetailPresenter();
    }
}