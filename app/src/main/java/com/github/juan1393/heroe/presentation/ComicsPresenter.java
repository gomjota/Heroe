package com.github.juan1393.heroe.presentation;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.GetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.useCase.GetCharacterComicsUseCase;
import com.github.juan1393.heroe.presentation.base.BasePresenter;
import com.github.juan1393.heroe.ui.activity.ComicsActivity;
import com.github.juan1393.heroe.ui.adapter.displayModel.ComicsDisplayModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicsPresenter extends BasePresenter<ComicsActivity> implements GetCharacterComicsResponse {

    private final int CHARACTER_CAPTAIN_AMERICA_ID = 1009220;
    private final int MAX_COMICS = 20;

    private GetCharacterComicsUseCase getCharacterComicsUseCase;
    private List<Comic> comics;

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
        comics = new ArrayList<>();
        GetCharacterComicsRequest request = new GetCharacterComicsRequest(CHARACTER_CAPTAIN_AMERICA_ID,
                MAX_COMICS);
        getCharacterComicsUseCase.execute(request, this);
    }

    @Override
    public void onCharacterComicsRetrieved(List<Comic> comics) {
        this.comics = comics;
        if (isViewEnabled()) {
            ComicsDisplayModel comicsDisplayModel = new ComicsDisplayModel(comics);
            view.hideProgressWheel();
            view.setDataInComicList(comicsDisplayModel);
        }
    }

    @Override
    public void onCharacterComicsNotFound() {
        if (isViewEnabled()) {
            view.hideProgressWheel();
            view.showCharacterComicsNotFoundError();
        }
    }

    @Override
    public void onNetworkConnectionError() {
        if (isViewEnabled()) {
            view.hideProgressWheel();
            view.showNetworkConnectionError();
        }
    }

    public void onItemOnListClicked(int position) {
        navigator.goToComicDetailActivity(comics.get(position));
    }
}
