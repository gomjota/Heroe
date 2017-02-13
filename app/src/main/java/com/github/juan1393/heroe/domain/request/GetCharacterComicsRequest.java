package com.github.juan1393.heroe.domain.request;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class GetCharacterComicsRequest extends BaseRequest {

    private int characterId;
    private int maxComics;

    public GetCharacterComicsRequest(int characterId, int maxComics) {
        this.characterId = characterId;
        this.maxComics = maxComics;
    }

    public int getCharacterId() {
        return characterId;
    }

    public int getMaxComics() {
        return maxComics;
    }
}
