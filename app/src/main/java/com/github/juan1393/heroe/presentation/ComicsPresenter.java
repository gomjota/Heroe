package com.github.juan1393.heroe.presentation;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.GetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.useCase.GetCharacterComicsUseCase;
import com.github.juan1393.heroe.ui.activity.ComicsActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicsPresenter extends BasePresenter<ComicsActivity> implements GetCharacterComicsResponse {

    private final int CHARACTER_CAPTAIN_AMERICA_ID = 1009220;

    private GetCharacterComicsUseCase getCharacterComicsUseCase;

    @Inject
    public ComicsPresenter(GetCharacterComicsUseCase getCharacterComicsUseCase) {
        this.getCharacterComicsUseCase = getCharacterComicsUseCase;
    }

    @Override
    public void onViewEnabled() {
        super.onViewEnabled();
        view.configureComicList();
        executeGetCharacterComicsUseCase();
    }

    private void executeGetCharacterComicsUseCase() {
        GetCharacterComicsRequest request = new GetCharacterComicsRequest(CHARACTER_CAPTAIN_AMERICA_ID);
        getCharacterComicsUseCase.execute(request, this);
    }

    @Override
    public void onCharacterComicsRetrieved(List<Comic> comics) {

    }

    @Override
    public void onCharacterComicsNotFound() {

    }

    @Override
    public void onNetworkConnectionError() {

    }
}
