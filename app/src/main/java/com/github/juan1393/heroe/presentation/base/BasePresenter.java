package com.github.juan1393.heroe.presentation.base;

import com.github.juan1393.heroe.app.navigator.Navigator;
import com.github.juan1393.heroe.ui.View;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class BasePresenter<T extends View> extends Presenter<T> {

    protected Navigator navigator;

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void onCreate() {

    }

    public void onResume() {

    }

    public void onPause() {
    }

    public void onDestroy() {

    }
}

