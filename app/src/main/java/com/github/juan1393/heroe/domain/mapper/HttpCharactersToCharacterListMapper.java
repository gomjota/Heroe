package com.github.juan1393.heroe.domain.mapper;

import android.util.Log;

import com.github.juan1393.heroe.app.model.Character;
import com.github.juan1393.heroe.data.http.model.HttpCharacter;
import com.github.juan1393.heroe.data.http.model.HttpCharacters;
import com.github.juan1393.heroe.domain.mapper.exception.InfoNotAvailableException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class HttpCharactersToCharacterListMapper implements Mapper<HttpCharacters, List<Character>> {

    private final String TAG = "HttpCharactersMapper";
    private HttpCharacterToCharacterMapper httpCharacterToCharacterMapper;

    public HttpCharactersToCharacterListMapper() {
        httpCharacterToCharacterMapper = new HttpCharacterToCharacterMapper();
    }

    @Override
    public List<Character> map(HttpCharacters input) {
        List<Character> creators = new ArrayList<>();
        try {
            creators = getCharacters(input);
        } catch (InfoNotAvailableException e) {
            Log.d(TAG, "Info is not available");
        }

        return creators;
    }

    private List<Character> getCharacters(HttpCharacters input) throws InfoNotAvailableException {
        if(input.getCharacters() != null) {
            List<Character> characters = new ArrayList<>();
            for(HttpCharacter httpCharacter : input.getCharacters()) {
                characters.add(httpCharacterToCharacterMapper.map(httpCharacter));
            }
            return characters;
        }

        throw new InfoNotAvailableException();
    }
}
