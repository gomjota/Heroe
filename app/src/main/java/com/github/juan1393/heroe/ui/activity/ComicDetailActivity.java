package com.github.juan1393.heroe.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.juan1393.heroe.R;
import com.github.juan1393.heroe.app.di.component.AppComponent;
import com.github.juan1393.heroe.app.di.component.DaggerComicDetailComponent;
import com.github.juan1393.heroe.app.di.module.ComicDetailModule;
import com.github.juan1393.heroe.presentation.ComicDetailPresenter;
import com.github.juan1393.heroe.presentation.base.BasePresenter;
import com.github.juan1393.heroe.ui.activity.base.BaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ComicDetailActivity extends BaseActivity {

    @Inject
    ComicDetailPresenter comicDetailPresenter;

    @BindView(R.id.toolbar_back)
    Toolbar toolbar;
    @BindView(R.id.comic_detail_image)
    ImageView comicDetailImage;
    @BindView(R.id.comic_detail_title)
    TextView comicDetailTitle;
    @BindView(R.id.comic_detail_description)
    TextView comicDetailDescription;
    @BindView(R.id.comic_detail_characters)
    TextView comicDetailCharacters;
    @BindView(R.id.comic_detail_creators)
    TextView comicDetailCreators;
    @BindView(R.id.comic_detail_release_date)
    TextView comicDetailReleaseDate;
    @BindView(R.id.comic_detail_price)
    TextView comicDetailPrice;
    @BindView(R.id.comic_detail_scroll)
    NestedScrollView comicDetailScroll;

    @Override
    public void setupInjection(AppComponent appComponent) {
        DaggerComicDetailComponent.builder()
                .appComponent(appComponent)
                .comicDetailModule(new ComicDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comicDetailPresenter.setIntentParams(getIntent());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_comic_detail;
    }

    @Override
    public BasePresenter getPresenter() {
        return comicDetailPresenter;
    }

    public void configureToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    public void setHeaderImage(String imageUrl) {
        Picasso.with(this)
                .load(imageUrl)
                .into(comicDetailImage);
    }

    public void setTitle(String title) {
        comicDetailTitle.setText(title);
    }

    public void setDescription(String description) {
        comicDetailDescription.setText(description);
    }

    public void setCharacters(String characters) {
        comicDetailCharacters.setText(characters);
    }

    public void setCreators(String creators) {
        comicDetailCreators.setText(creators);
    }

    public void setReleaseDate(String date) {
        comicDetailReleaseDate.setText(date);
    }

    public void setPrice(String price) {
        comicDetailPrice.setText(price);
    }

    @OnClick(R.id.toolbar_clickable)
    public void onClick() {
        comicDetailPresenter.onToolbarClicked();
    }
}
