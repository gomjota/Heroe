package com.github.juan1393.heroe.domain.request;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class GetCharacterComicsRequest extends BaseRequest {

    private int characterId;

    public GetCharacterComicsRequest(int characterId) {
        this.characterId = characterId;
    }

    public int getCharacterId() {
        return characterId;
    }
}
