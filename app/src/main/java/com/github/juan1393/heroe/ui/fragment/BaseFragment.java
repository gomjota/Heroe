package com.github.juan1393.heroe.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.juan1393.heroe.Heroe;
import com.github.juan1393.heroe.presentation.BasePresenter;
import com.github.juan1393.heroe.ui.View;

import butterknife.ButterKnife;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class BaseFragment extends Fragment implements View {

    private int layoutReference;
    private BasePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupInjection(Heroe.getInstance().getAppComponent());
        presenter = getPresenter();
        presenter.onCreate();
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        layoutReference = getLayoutId();
        return inflater.inflate(layoutReference, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        ButterKnife.bind(this, getView());
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
