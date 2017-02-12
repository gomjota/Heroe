package com.github.juan1393.heroe.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.juan1393.heroe.R;
import com.github.juan1393.heroe.app.di.component.AppComponent;
import com.github.juan1393.heroe.app.di.component.DaggerComicsComponent;
import com.github.juan1393.heroe.app.di.module.ComicsModule;
import com.github.juan1393.heroe.presentation.BasePresenter;
import com.github.juan1393.heroe.presentation.ComicsPresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class ComicsActivity extends BaseActivity {

    @Inject
    ComicsPresenter comicsPresenter;

    @BindView(R.id.comic_list)
    RecyclerView comicList;

    @Override
    public void setupInjection(AppComponent appComponent) {
        DaggerComicsComponent.builder()
                .appComponent(appComponent)
                .comicsModule(new ComicsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_comics;
    }

    @Override
    public BasePresenter getPresenter() {
        return comicsPresenter;
    }

    public void configureComicList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        comicList.setLayoutManager(linearLayoutManager);
    }
}
