package com.epam.shop.service.dto.model;

public class AbstractModelDto<T> {
    protected T id;

    public AbstractModelDto() {

    }

    public AbstractModelDto(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
