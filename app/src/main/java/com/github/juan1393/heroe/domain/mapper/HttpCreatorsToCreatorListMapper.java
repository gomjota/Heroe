package com.github.juan1393.heroe.domain.mapper;

import com.github.juan1393.heroe.app.model.Creator;
import com.github.juan1393.heroe.data.http.model.HttpCreator;
import com.github.juan1393.heroe.data.http.model.HttpCreators;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpCreatorsToCreatorListMapper implements Mapper<HttpCreators, List<Creator>> {

    private HttpCreatorToCreatorMapper httpCreatorToCreatorMapper;

    public HttpCreatorsToCreatorListMapper() {
        httpCreatorToCreatorMapper = new HttpCreatorToCreatorMapper();
    }

    @Override
    public List<Creator> map(HttpCreators input) {
        List<Creator> creators = new ArrayList<>();
        try {
            creators = getCreators(input);
        } catch (InfoNotAvailableException e) {
            //TODO
        }

        return creators;
    }

    private List<Creator> getCreators(HttpCreators input) throws InfoNotAvailableException {
        if(input.getCreators() != null) {
            List<Creator> creators = new ArrayList<>();
            for(HttpCreator httpCreator : input.getCreators()) {
                creators.add(httpCreatorToCreatorMapper.map(httpCreator));
            }
            return creators;
        }

        throw new InfoNotAvailableException();
    }
}
