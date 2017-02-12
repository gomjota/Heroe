package com.github.juan1393.heroe.domain.mapper;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public interface Mapper<I, O> {
    O map(I input);
}
