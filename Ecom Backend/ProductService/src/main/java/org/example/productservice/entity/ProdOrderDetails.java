package org.example.productservice.entity;

import jakarta.persistence.*;

@Entity
public class ProdOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer prodOrderDetailId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Products products;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    Orders   orders;
    Integer itemCount;
    Integer totalCost;

    public Integer getProdOrderDetailId() {
        return prodOrderDetailId;
    }

    public void setProdOrderDetailId(Integer prodOrderDetailId) {
        this.prodOrderDetailId = prodOrderDetailId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }
}
