package com.epam.shop.service.dto.model;

import java.util.Objects;

public class ProductDto extends AbstractDto<Integer> {
    private String name;
    private Double cost;
    private Integer categoryId;
    private Integer brandId;

    public ProductDto() {
    }

    public ProductDto(Integer id) {
        super(id);
    }

    public ProductDto(String name, Double cost, Integer categoryId, Integer brandId) {
        this.name = name;
        this.cost = cost;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(categoryId, that.categoryId) && Objects.equals(brandId, that.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, categoryId, brandId);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }
}
