package com.github.juan1393.heroe.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.github.juan1393.heroe.R;
import com.github.juan1393.heroe.app.di.component.AppComponent;
import com.github.juan1393.heroe.app.di.component.DaggerComicsComponent;
import com.github.juan1393.heroe.app.di.module.ComicsModule;
import com.github.juan1393.heroe.presentation.base.BasePresenter;
import com.github.juan1393.heroe.presentation.ComicsPresenter;
import com.github.juan1393.heroe.ui.activity.base.BaseActivity;
import com.github.juan1393.heroe.ui.adapter.ComicsAdapter;
import com.github.juan1393.heroe.ui.adapter.RecyclerViewItemClicked;
import com.github.juan1393.heroe.ui.adapter.displayModel.ComicsDisplayModel;
import com.pnikosis.materialishprogress.ProgressWheel;

import javax.inject.Inject;

import butterknife.BindView;

public class ComicsActivity extends BaseActivity implements RecyclerViewItemClicked {

    @Inject
    ComicsPresenter comicsPresenter;

    @BindView(R.id.comic_list)
    RecyclerView comicList;
    @BindView(R.id.progress_wheel)
    ProgressWheel progressWheel;

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
        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        comicList.setLayoutManager(staggeredGridLayoutManager);
    }

    public void setDataInComicList(ComicsDisplayModel comicsDisplayModel) {
        ComicsAdapter comicsAdapter = new ComicsAdapter(this, this, comicsDisplayModel);
        comicList.setAdapter(comicsAdapter);
    }

    public void showProgressWheel() {
        progressWheel.spin();
    }

    public void hideProgressWheel() {
        progressWheel.stopSpinning();
    }

    public void showCharacterComicsNotFoundError() {
        Toast.makeText(this, getString(R.string.error_character_comics_not_found), Toast.LENGTH_SHORT).show();
    }

    public void showNetworkConnectionError() {
        Toast.makeText(this, getString(R.string.error_network_connection), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(int position) {
        comicsPresenter.onItemOnListClicked(position);
    }
}
