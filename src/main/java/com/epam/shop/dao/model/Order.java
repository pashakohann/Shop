package com.epam.shop.dao.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order extends AbstractModel<Integer> {

    private List<Product> listProducts;
    private LocalDateTime orderDate;
    private Double orderCost;
    private Integer userId;

    public Order() {
    }

    public Order(Integer id) {
        super(id);
    }

    public Order(List<Product> listProducts, LocalDateTime orderDate, Double orderCost, Integer userId) {
        this.listProducts = listProducts;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.userId = userId;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
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
        return Objects.equals(listProducts, order.listProducts) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderCost, order.orderCost) && Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listProducts, orderDate, orderCost, userId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "listProducts=" + listProducts +
                ", orderDate=" + orderDate +
                ", orderCost=" + orderCost +
                ", userId=" + userId +
                '}';
    }
}
