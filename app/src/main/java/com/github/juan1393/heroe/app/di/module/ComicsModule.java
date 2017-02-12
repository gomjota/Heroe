package com.github.juan1393.heroe.app.di.module;

import com.github.juan1393.heroe.app.di.scope.PerView;
import com.github.juan1393.heroe.domain.useCase.GetCharacterComicsUseCase;
import com.github.juan1393.heroe.presentation.ComicsPresenter;
import com.github.juan1393.heroe.ui.activity.ComicsActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juan Gómez on 12/2/17.
 */

@Module
public class ComicsModule {

    private ComicsActivity comicsActivity;

    public ComicsModule(ComicsActivity comicsActivity) {
        this.comicsActivity = comicsActivity;
    }

    @Provides
    @PerView
    ComicsActivity provideActivity() {
        return comicsActivity;
    }

    @Provides
    @PerView
    ComicsPresenter providePresenter(GetCharacterComicsUseCase getCharacerComicsUseCase) {
        return new ComicsPresenter(getCharacerComicsUseCase);
    }
}