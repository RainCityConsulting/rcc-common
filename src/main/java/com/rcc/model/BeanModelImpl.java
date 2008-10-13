package com.rcc.model;

import com.rcc.beans.Identifiable;

import static org.jvnet.inflector.Noun.pluralOf;

import java.util.List;

public class BeanModelImpl<T extends Identifiable> extends ModelBase implements BeanModel<T> {
    private String beanName;

    public BeanModelImpl() { ; }

    public BeanModelImpl(String beanName) {
        this.beanName = beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public int create(Identifiable ident) {
        Integer id = (Integer) this.getSqlMapClientTemplate().insert(
                "insert" + this.beanName, ident);
        return id.intValue();
    }

    public void update(Identifiable ident) {
        this.getSqlMapClientTemplate().insert("update" + this.beanName, ident);
    }

    public int delete(int id) {
        return this.getSqlMapClientTemplate().delete("delete" + this.beanName, id);
    }

    public T findById(int id) {
        T t = (T) this.getSqlMapClientTemplate().queryForObject(
                "find" + this.beanName + "ById", id);
        if (t == null) {
            throw new ObjectNotFoundException(id);
        }
        return t;
    }

    public List<T> findAll() {
        return (List<T>) this.getSqlMapClientTemplate().queryForList(
                "findAll" + pluralOf(this.beanName));
    }

    public List<T> findAll(int offset, int limit) {
        return (List<T>) this.getSqlMapClientTemplate().queryForList(
                "findAll" + pluralOf(this.beanName), null, offset, limit);
    }

    public int findCount() {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(
                String.format("find%sCount", this.beanName));
    }
}
