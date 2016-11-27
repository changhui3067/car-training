package com.car.training.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by bill on 11/20/16.
 */
@Component
public class BeanOperation {
    public void setValue(Object from, Object to, String[] props) {
        setValue(from, to, props, props);
    }

    public boolean existNull(Object object, String[] checkProps) {
        if (checkProps == null) {
            return false;
        }
        for (String prop : checkProps) {
            try {
                Field field = object.getClass().getDeclaredField(prop);
                field.setAccessible(true);
                if (field.get(object) == null) {
                    return true;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void setValue(Object from, Object to, String[] fromProps, String[] toProps) {
        if (fromProps.length != toProps.length) {
            return;
        }
        for (int i = 0; i < fromProps.length; i++) {
            try {
                String fromProp = fromProps[i];
                String toProp = toProps[i];
                Field fromField = from.getClass().getDeclaredField(fromProp);
                Field toField = to.getClass().getDeclaredField(toProp);
                fromField.setAccessible(true);
                toField.setAccessible(true);
                Object val = fromField.get(from);
                if (val != null) {
                    toField.set(to, val);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void setField(Object object,String fieldName , Object value) {
        Field fromField = null;
        try {
            fromField = object.getClass().getDeclaredField(fieldName);
            fromField.setAccessible(true);
fromField.set(object,value);
        } catch (NoSuchFieldException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }
}
