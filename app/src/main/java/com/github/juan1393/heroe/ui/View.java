package com.github.juan1393.heroe.ui;

import com.github.juan1393.heroe.app.di.component.AppComponent;
import com.github.juan1393.heroe.presentation.base.BasePresenter;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public interface View {

    void setupInjection(AppComponent appComponent);

    int getLayoutId();

    BasePresenter getPresenter();
}
