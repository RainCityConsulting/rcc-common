package com.rcc.model;

import com.rcc.beans.Identifiable;

import java.util.List;

public interface BeanQuery<T extends Identifiable> {
    public T findById(int id);
    public List<T> findAll();
    public List<T> findAll(int offset, int limit);

    public int findCount();
}
