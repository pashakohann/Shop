package com.epam.shop.service.dto.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrderDto extends AbstractModelDto<Integer> {
    private List<ProductDto> listProducts;
    private LocalDateTime orderDate;
    private BigDecimal orderCost;
    private Integer userId;

    public OrderDto() {
    }

    public OrderDto(Integer id) {
        super(id);
    }

    public OrderDto(List<ProductDto> listProducts, LocalDateTime orderDate, BigDecimal orderCost, Integer userId) {
        this.listProducts = listProducts;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.userId = userId;
    }

    public List<ProductDto> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ProductDto> listProducts) {
        this.listProducts = listProducts;
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
        return Objects.equals(listProducts, orderDto.listProducts) && Objects.equals(orderDate, orderDto.orderDate) && Objects.equals(orderCost, orderDto.orderCost) && Objects.equals(userId, orderDto.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listProducts, orderDate, orderCost, userId);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", listProducts=" + listProducts +
                ", orderDate=" + orderDate +
                ", orderCost=" + orderCost +
                ", userId=" + userId +
                '}';
    }
}
