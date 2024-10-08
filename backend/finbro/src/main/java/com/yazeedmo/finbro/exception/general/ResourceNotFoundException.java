package com.yazeedmo.finbro.exception.general;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> clazz, String fieldName, String data) {
        super(String.format("Cannot find %s with %s: %s",
                clazz.getSimpleName(), fieldName, data));
    }

}
