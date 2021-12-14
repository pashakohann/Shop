package com.epam.shop.dao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Order extends AbstractModel<Integer> {

    private Map<Product,Integer> mapProducts;
    private LocalDateTime orderDate;
    private BigDecimal orderCost;
    private Integer userId;

    public Order() {
    }

    public Order(Integer id) {
        super(id);
    }

    public Order(Map<Product,Integer> mapProducts, LocalDateTime orderDate, BigDecimal orderCost, Integer userId) {
        this.mapProducts = mapProducts;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.userId = userId;
    }

    public Map<Product,Integer>  getMapProducts() {
        return mapProducts;
    }

    public void setMapProducts(Map<Product,Integer> mapProducts) {
        this.mapProducts = mapProducts;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(mapProducts, order.mapProducts) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderCost, order.orderCost) && Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapProducts, orderDate, orderCost, userId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", mapProducts=" + mapProducts +
                ", orderDate=" + orderDate +
                ", orderCost=" + orderCost +
                ", userId=" + userId +
                '}';
    }
}
