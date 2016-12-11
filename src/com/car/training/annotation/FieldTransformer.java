package com.car.training.annotation;

/**
 * Created by bill on 12/11/16.
 */
public class FieldTransformer {
    private String fieldName;
    private Transformer transformer;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }
}
