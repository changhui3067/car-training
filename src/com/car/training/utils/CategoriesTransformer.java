package com.car.training.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bill on 11/23/16.
 */
public class CategoriesTransformer {
    public static Set<String> transform(String categories){
        HashSet<String> set = new HashSet<>();
        if(!StringUtils.isEmpty(categories)){
            set.addAll(Arrays.asList(categories.split(",")));
        }
        return set;
    }
}
