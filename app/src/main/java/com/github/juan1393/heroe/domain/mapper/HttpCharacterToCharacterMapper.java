package com.github.juan1393.heroe.domain.mapper;

import android.util.Log;

import com.github.juan1393.heroe.app.model.Character;
import com.github.juan1393.heroe.data.http.model.HttpCharacter;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class HttpCharacterToCharacterMapper implements Mapper<HttpCharacter, Character> {

    private final String TAG = "HttpCharacterMapper";

    @Override
    public Character map(HttpCharacter input) {
        Character character = new Character();
        try {
            character.setName(getName(input));
        } catch (InfoNotAvailableException e) {
            Log.d(TAG, "Info is not available");
        }
        return character;
    }

    private String getName(HttpCharacter input) throws InfoNotAvailableException {
        if (input.getName() != null) {
            return input.getName();
        }
        throw new InfoNotAvailableException();
    }
}
