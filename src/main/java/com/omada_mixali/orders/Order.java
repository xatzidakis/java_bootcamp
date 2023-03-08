package com.omada_mixali.orders;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProduct;
    private Double discountPercent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
