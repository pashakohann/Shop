package com.epam.shop.service.dto.model;

public class AbstractDto<T> {
    protected T id;

    public AbstractDto() {

    }

    public AbstractDto(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
