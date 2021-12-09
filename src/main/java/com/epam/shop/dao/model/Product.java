package com.epam.shop.dao.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product extends AbstractModel<Integer> {
    private String name;
    private BigDecimal cost;
    private Integer categoryId;
    private Integer brandId;
    private String photoLink;

    public Product() {
    }

    public Product(Integer id) {
        super(id);
    }

    public Product(Integer id, String name, BigDecimal cost, Integer categoryId, Integer brandId, String photoLink) {
        super(id);
        this.name = name;
        this.cost = cost;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.photoLink = photoLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
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

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(cost, product.cost) && Objects.equals(categoryId, product.categoryId) && Objects.equals(brandId, product.brandId) && Objects.equals(photoLink, product.photoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, categoryId, brandId, photoLink);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", photoLink='" + photoLink + '\'' +
                '}';
    }
}
