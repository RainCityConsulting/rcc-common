package com.rcc.model;

import com.rcc.beans.Identifiable;

import java.util.List;

public interface BeanUpdate<T extends Identifiable> {
    public int create(Identifiable ident);
    public void update(Identifiable ident);
    public int delete(int id);
}
