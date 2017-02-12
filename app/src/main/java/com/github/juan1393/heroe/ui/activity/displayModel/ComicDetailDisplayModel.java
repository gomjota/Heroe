package com.github.juan1393.heroe.ui.activity.displayModel;

import com.github.juan1393.heroe.app.model.Character;
import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.app.model.Creator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicDetailDisplayModel {

    private String imageUrl;
    private String title;
    private String description;
    private String characters;
    private String creators;
    private String releaseDate;
    private String price;

    public ComicDetailDisplayModel(Comic comic) {
        this.imageUrl = randomImage(comic);
        this.title = formatTitle(comic);
        this.description = formatDescription(comic);
        this.characters = formatCharacters(comic);
        this.creators = formatCreators(comic);
        this.releaseDate = formatReleaseDate(comic);
        this.price = formatPrice(comic);
    }

    private String randomImage(Comic comic) {
        Random random = new Random();
        int index = random.nextInt(comic.getImagesUrl().size());
        return comic.getImagesUrl().get(index);
    }

    private String formatTitle(Comic comic) {
        return comic.getTitle();
    }

    private String formatDescription(Comic comic) {
        return comic.getDescription();
    }

    private String formatCharacters(Comic comic) {
        String characters = "";
        for (int i = 0; i < comic.getCharacters().size(); i++) {
            Character character = comic.getCharacters().get(i);
            characters += character.getName();
            if (i != comic.getCharacters().size() - 1) {
                characters += ", ";
            }
        }
        return characters;
    }

    private String formatCreators(Comic comic) {
        String creators = "";
        for (int i = 0; i < comic.getCreators().size(); i++) {
            Creator creator = comic.getCreators().get(i);
            creators += creator.getName();
            if (i != comic.getCreators().size() - 1) {
                creators += ", ";
            }
        }
        return creators;
    }

    private String formatReleaseDate(Comic comic) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(comic.getReleaseDate());
    }

    private String formatPrice(Comic comic) {
        return String.valueOf(comic.getPrintPrice());
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCharacters() {
        return characters;
    }

    public String getCreators() {
        return creators;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPrice() {
        return price;
    }
}
