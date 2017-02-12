package com.github.juan1393.heroe.app.navigator;

import android.content.Intent;
import android.os.Bundle;

import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.presentation.ComicDetailPresenter;
import com.github.juan1393.heroe.ui.activity.BaseActivity;
import com.github.juan1393.heroe.ui.activity.ComicDetailActivity;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class Navigator {

    private BaseActivity currentActivity;

    public void setCurrentActivity(BaseActivity currentActivity) {
        this.currentActivity = currentActivity;
    }

    public void goToComicDetailActivity(Comic comic) {
        Intent intent = new Intent(currentActivity, ComicDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ComicDetailPresenter.COMIC_PARAMETER, comic);
        intent.putExtras(bundle);
        currentActivity.startActivity(intent);
    }

    public void finishActivity() {
        if(currentActivity != null) {
            currentActivity.finish();
        }
    }
}
