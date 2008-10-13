package com.rcc.model;

import com.rcc.beans.Identifiable;

import java.util.List;

public interface BeanModel<T extends Identifiable> extends BeanQuery, BeanUpdate {
    public int create(Identifiable ident);
    public void update(Identifiable ident);
    public int delete(int id);

    public T findById(int id);
    public List<T> findAll();
    public List<T> findAll(int offset, int limit);

    public int findCount();
}
