package com.rcc.model;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(int id) {
        super(String.valueOf(id));
    }

    public ObjectNotFoundException(Class c, int id) {
        super(c.getName() + ": " + id);
    }
}
