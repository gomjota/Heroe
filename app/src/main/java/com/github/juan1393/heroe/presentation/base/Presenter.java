package com.github.juan1393.heroe.presentation.base;

import com.github.juan1393.heroe.ui.View;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class Presenter<T extends View> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    public void onViewEnabled() {
    }

    public boolean isViewEnabled() {
        return view != null;
    }
}

