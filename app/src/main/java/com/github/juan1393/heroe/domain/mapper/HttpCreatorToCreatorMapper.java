package com.github.juan1393.heroe.domain.mapper;

import android.util.Log;

import com.github.juan1393.heroe.app.model.Creator;
import com.github.juan1393.heroe.data.http.model.HttpCreator;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class HttpCreatorToCreatorMapper implements Mapper<HttpCreator, Creator> {

    private final String TAG = "HttpCreatorMapper";

    @Override
    public Creator map(HttpCreator input) {
        Creator creator = new Creator();
        try {
            creator.setName(getName(input));
            creator.setRole(getRole(input));
        } catch (InfoNotAvailableException e) {
            Log.d(TAG, "Info is not available");
        }
        return creator;
    }

    private String getName(HttpCreator input) throws InfoNotAvailableException {
        if (input.getName() != null) {
            return input.getName();
        }
        throw new InfoNotAvailableException();
    }

    private String getRole(HttpCreator input) throws InfoNotAvailableException {
        if (input.getRole() != null) {
            return input.getRole();
        }
        throw new InfoNotAvailableException();
    }
}
