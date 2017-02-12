package com.github.juan1393.heroe.domain.mapper;

import com.github.juan1393.heroe.app.model.Character;
import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.app.model.Creator;
import com.github.juan1393.heroe.data.http.model.HttpDate;
import com.github.juan1393.heroe.data.http.model.HttpImage;
import com.github.juan1393.heroe.data.http.model.HttpPrice;
import com.github.juan1393.heroe.data.http.model.HttpResult;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpResultToComicMapper implements Mapper<HttpResult, Comic> {

    /*String name;
    private String description;
    private int pageCount;
    private Date releaseDate;
    private float printPrice;
    private String thumbnailUrl;
    private List<String> imagesUrl;
    private List<Creator> creators;
    private List<Character> characters;*/

    private HttpCreatorsToCreatorListMapper httpCreatorsToCreatorListMapper;
    private HttpCharactersToCharacterListMapper httpCharactersToCharacterListMapper;

    public HttpResultToComicMapper() {
        this.httpCreatorsToCreatorListMapper = new HttpCreatorsToCreatorListMapper();
        this.httpCharactersToCharacterListMapper = new HttpCharactersToCharacterListMapper();
    }

    @Override
    public Comic map(HttpResult input) {
        Comic comic = new Comic();

        try {
            comic.setId(getId(input));
            comic.setTitle(getTitle(input));
            comic.setDescription(getDescription(input));
            comic.setPageCount(getPageCount(input));
            comic.setReleaseDate(getReleaseDate(input));
            comic.setPrintPrice(getPrintPrice(input));
            comic.setThumbnailUrl(getThumbnailUrl(input));
            comic.setImagesUrl(getImagesUrl(input));
            comic.setCreators(getCreators(input));
            comic.setCharacters(getCharacters(input));
        } catch (InfoNotAvailableException e) {
            //TODO
        }

        return comic;
    }

    private int getId(HttpResult input) throws InfoNotAvailableException {
        if(input.getId() > 0) {
            return input.getId();
        }
        throw new InfoNotAvailableException();
    }

    private String getTitle(HttpResult input) throws InfoNotAvailableException {
        if(input.getTitle() != null) {
            return input.getTitle();
        }
        throw new InfoNotAvailableException();
    }

    private String getDescription(HttpResult input) throws InfoNotAvailableException {
        if(input.getDescription() != null) {
            return input.getDescription();
        }
        throw new InfoNotAvailableException();
    }

    private int getPageCount(HttpResult input) throws InfoNotAvailableException {
        if(input.getPageCount() > 0) {
            return input.getPageCount();
        }
        throw new InfoNotAvailableException();
    }

    private Date getReleaseDate(HttpResult input) throws InfoNotAvailableException {
        if(input.getPrices() != null) {
            for (HttpDate httpDate : input.getDates()) {
                if (httpDate.getType().equals("onsaleDate")) {
                    return httpDate.getDate();
                }
            }
        }
        throw new InfoNotAvailableException();
    }

    private float getPrintPrice(HttpResult input) throws InfoNotAvailableException {
        if(input.getPrices() != null) {
            for (HttpPrice httpPrice : input.getPrices()) {
                if (httpPrice.getType().equals("printPrice")) {
                    return httpPrice.getPrice();
                }
            }
        }
        throw new InfoNotAvailableException();
    }

    private String getThumbnailUrl(HttpResult input) throws InfoNotAvailableException {
        if(input.getThumbnail() != null) {
            return input.getThumbnail().getPath() + "." + input.getThumbnail().getExtension();
        }
        throw new InfoNotAvailableException();
    }

    private List<String> getImagesUrl(HttpResult input) throws InfoNotAvailableException {
        if(input.getImages() != null) {
            List<String> imagesUrl = new ArrayList<>();
            for(HttpImage httpImage : input.getImages()) {
                String url = httpImage.getPath() + "." + httpImage.getExtension();
                imagesUrl.add(url);
            }
            return imagesUrl;
        }
        throw new InfoNotAvailableException();
    }
    
    private List<Creator> getCreators(HttpResult input) throws InfoNotAvailableException {
        if(input.getCreators() != null) {
            return httpCreatorsToCreatorListMapper.map(input.getCreators());
        }
        throw new InfoNotAvailableException();
    }

    private List<Character> getCharacters(HttpResult input) throws InfoNotAvailableException {
        if(input.getCharacters() != null) {
            return httpCharactersToCharacterListMapper.map(input.getCharacters());
        }
        throw new InfoNotAvailableException();
    }
}
