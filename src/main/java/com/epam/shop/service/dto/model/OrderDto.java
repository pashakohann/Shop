package com.epam.shop.service.dto.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Map;
import java.util.Objects;

public class OrderDto extends AbstractModelDto<Integer> {
    private Map<ProductDto,Integer> mapProducts;
    private LocalDateTime orderDate;
    private BigDecimal orderCost;
    private Integer userId;

    public OrderDto() {
    }

    public OrderDto(Integer id) {
        super(id);
    }

    public OrderDto(Map<ProductDto,Integer> mapProducts, LocalDateTime orderDate, BigDecimal orderCost, Integer userId) {
        this.mapProducts = mapProducts;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.userId = userId;
    }

    public Map<ProductDto,Integer> getMapProducts() {
        return mapProducts;
    }

    public void setMapProducts(Map<ProductDto,Integer> mapProducts) {
        this.mapProducts =mapProducts;
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
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(mapProducts, orderDto.mapProducts) && Objects.equals(orderDate, orderDto.orderDate) && Objects.equals(orderCost, orderDto.orderCost) && Objects.equals(userId, orderDto.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapProducts, orderDate, orderCost, userId);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", mapProducts=" + mapProducts +
                ", orderDate=" + orderDate +
                ", orderCost=" + orderCost +
                ", userId=" + userId +
                '}';
    }
}
