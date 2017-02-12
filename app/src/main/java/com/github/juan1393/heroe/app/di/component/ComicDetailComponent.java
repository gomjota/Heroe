package com.github.juan1393.heroe.app.di.component;

import com.github.juan1393.heroe.app.di.module.ComicDetailModule;
import com.github.juan1393.heroe.app.di.scope.PerView;
import com.github.juan1393.heroe.ui.activity.ComicDetailActivity;

import dagger.Component;

/**
 * Created by Juan Gómez on 12/2/17.
 */

@PerView
@Component(modules = ComicDetailModule.class, dependencies = AppComponent.class)
public interface ComicDetailComponent {
    ComicDetailActivity inject(ComicDetailActivity comicDetailActivity);
}
