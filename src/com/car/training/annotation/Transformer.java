package com.car.training.annotation;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by bill on 12/11/16.
 */
public interface Transformer {

    Object transform(String s);

    Map<String, Transformer> transformerMap = new HashMap<>();

    static Transformer getTransformer(String s) {
        return transformerMap.get(s);
    }

    class DateTransformer implements Transformer {
        @Override
        public Object transform(String s) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(s);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    class IntegerTransformer implements Transformer {
        @Override
        public Object transform(String s) {
            return Integer.valueOf(s);
        }
    }
    
    class CategoryTransformer implements Transformer {
        @Override
        public Object transform(String categoryString) {
            HashSet<String> categories = new HashSet<>();
            if (!StringUtils.isEmpty(categoryString)) {
                Collections.addAll(categories, categoryString.split(","));
            }
            return categories;
        }
    }
}
