package com.car.training.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by bill on 12/11/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface UIField {
    Class<? extends Transformer> transformer() default Transformer.class;
}
