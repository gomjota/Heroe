package com.github.juan1393.heroe.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.juan1393.heroe.Heroe;
import com.github.juan1393.heroe.presentation.BasePresenter;
import com.github.juan1393.heroe.ui.View;

import butterknife.ButterKnife;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements View {

    private android.view.View view;
    private BasePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupInjection(Heroe.getInstance().getAppComponent());
        int layoutId = getLayoutId();
        initView(layoutId);

        presenter = getPresenter();
        presenter.setView(this);
        presenter.onCreate();
    }

    private void initView(int layoutReference) {
        view = getLayoutInflater().inflate(layoutReference, null);
        setContentView(view);
        ButterKnife.bind(this);
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