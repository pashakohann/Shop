package com.epam.shop.dao.model;

public class AbstractModel<T> {
    protected T id;

    public AbstractModel() {
    }

    public AbstractModel(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
