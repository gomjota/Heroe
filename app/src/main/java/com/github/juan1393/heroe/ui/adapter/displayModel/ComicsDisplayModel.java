package com.github.juan1393.heroe.ui.adapter.displayModel;

import com.github.juan1393.heroe.app.model.Comic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicsDisplayModel {

    private List<ComicDisplayModel> comicDisplayModels = new ArrayList<>();

    public ComicsDisplayModel(List<Comic> comics) {
        for (Comic comic : comics) {
            comicDisplayModels.add(new ComicDisplayModel(comic));
        }
    }

    public ComicDisplayModel get(int position) {
        return comicDisplayModels.get(position);
    }

    public int size() {
        return comicDisplayModels.size();
    }

    public class ComicDisplayModel {

        private String title;
        private String thumbnail;

        public ComicDisplayModel(Comic comic) {
            this.title = comic.getTitle();
            this.thumbnail = comic.getThumbnailUrl();
        }

        public String getTitle() {
            return title;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
