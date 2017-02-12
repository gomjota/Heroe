package com.github.juan1393.heroe.presentation;

import android.content.Intent;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.presentation.base.BasePresenter;
import com.github.juan1393.heroe.ui.activity.ComicDetailActivity;
import com.github.juan1393.heroe.ui.activity.displayModel.ComicDetailDisplayModel;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicDetailPresenter extends BasePresenter<ComicDetailActivity> {

    public static final String COMIC_PARAMETER = "comic";
    private Comic comic;

    public void setIntentParams(Intent intent) {
        comic = (Comic) intent.getExtras().getSerializable(COMIC_PARAMETER);
        ComicDetailDisplayModel comicDetailDisplayModel = new ComicDetailDisplayModel(comic);
        view.setHeaderImage(comicDetailDisplayModel.getImageUrl());
        view.setTitle(comicDetailDisplayModel.getTitle());
        view.setDescription(comicDetailDisplayModel.getDescription());
        view.setCharacters(comicDetailDisplayModel.getCharacters());
        view.setCreators(comicDetailDisplayModel.getCreators());
        view.setReleaseDate(comicDetailDisplayModel.getReleaseDate());
        view.setPrice(comicDetailDisplayModel.getPrice());
    }

    @Override
    public void onViewEnabled() {
        super.onViewEnabled();
        view.configureToolbar();
    }

    public void onToolbarClicked() {
        navigator.finishActivity();
    }
}
