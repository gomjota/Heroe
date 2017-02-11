package com.github.juan1393.heroe.app.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Juan Gómez on 11/2/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME) public @interface PerView {}