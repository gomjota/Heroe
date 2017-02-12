package com.github.juan1393.heroe.data.http.request;

import com.github.juan1393.heroe.BuildConfig;
import com.github.juan1393.heroe.app.util.SecurityUtil;

import java.util.HashMap;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public abstract class MarvelAuthRequest<T> extends MarvelRequest<T> {

    private String PUBLIC_API_KEY = BuildConfig.MARVEL_PUBLIC_API_KEY;
    private String PRIVATE_API_KEY = BuildConfig.MARVEL_PRIVATE_API_KEY;
    private long currentTimestamp = System.currentTimeMillis();

    protected HashMap<String, Object> params = new HashMap<>();

    public MarvelAuthRequest() {
        addAuthParams();
    }

    private void addAuthParams() {
        String md5Digest = SecurityUtil.md5(currentTimestamp + PRIVATE_API_KEY + PUBLIC_API_KEY);
        params.put("apikey", PUBLIC_API_KEY);
        params.put("ts", String.valueOf(currentTimestamp));
        params.put("hash", md5Digest);
    }
}
