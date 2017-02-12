package com.github.juan1393.heroe.app.di.component;

import com.github.juan1393.heroe.app.di.module.ComicsModule;
import com.github.juan1393.heroe.app.di.scope.PerView;
import com.github.juan1393.heroe.ui.activity.ComicsActivity;

import dagger.Component;

/**
 * Created by Juan Gómez on 12/2/17.
 */


@PerView
@Component(modules = ComicsModule.class, dependencies = AppComponent.class)
public interface ComicsComponent {
    ComicsActivity inject(ComicsActivity comicsActivity);
}